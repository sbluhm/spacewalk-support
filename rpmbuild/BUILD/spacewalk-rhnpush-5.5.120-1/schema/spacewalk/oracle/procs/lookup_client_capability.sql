--
-- Copyright (c) 2008-2012 Red Hat, Inc.
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
lookup_client_capability(name_in in varchar2)
return number
is
    cap_name_id		number;
begin
    select id
      into cap_name_id
      from rhnClientCapabilityName
     where name = name_in;

    return cap_name_id;
exception when no_data_found then
    begin
        select insert_client_capability(name_in) into cap_name_id from dual;
    exception when dup_val_on_index then
        select id
          into cap_name_id
          from rhnClientCapabilityName
         where name = name_in;
    end;
	return cap_name_id;
end;
/
show errors
