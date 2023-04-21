--
-- Copyright (c) 2009-2012 Red Hat, Inc.
--
-- This software is licensed to you under the GNU General Public License,
-- version 2 (GPLv2). There is NO WARRANTY for this software, express or
-- implied, including the implied warranties of MERCHANTABILITY or FITNESS
-- FOR A PARTICULAR PURPOSE. You should have received a copy of GPLv2
-- along with this software; if not, see
-- http://www.gnu.org/licenses/old-licenses/gpl-2.0.txt.
--
-- Red Hat trademarks are not licensed under GPLv2. No permission is
-- granted to use or replicate Red Hat trademarks that are incorporated
-- in this software or its documentation.

create or replace function
lookup_checksum(checksum_type_in in varchar2, checksum_in in varchar2)
return number
is
        checksum_id     number;
begin
        if checksum_in is null then
                return null;
        end if;

        select c.id
          into checksum_id
          from rhnChecksumView c
         where c.checksum = checksum_in
           and c.checksum_type = checksum_type_in;

        return checksum_id;
exception when no_data_found then
    begin
        select insert_checksum(checksum_in, checksum_type_in) into checksum_id from dual;
    exception when dup_val_on_index then
        select c.id
          into checksum_id
          from rhnChecksumView c
         where c.checksum = checksum_in
          and c.checksum_type = checksum_type_in;
    end;
    return checksum_id;
end;
/
show errors
