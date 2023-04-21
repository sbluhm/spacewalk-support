--
-- Copyright (c) 2008--2012 Red Hat, Inc.
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
--


CREATE TABLE rhnKickstartPackage
(
    kickstart_id     NUMBER NOT NULL
                         CONSTRAINT rhn_kspackage_ksid_fk
                             REFERENCES rhnKSData (id)
                             ON DELETE CASCADE,
    package_name_id  NUMBER NOT NULL
                         CONSTRAINT rhn_kspackage_pnid_fk
                             REFERENCES rhnPackageName (id),
    position         NUMBER NOT NULL,
    created          timestamp with local time zone
                         DEFAULT (current_timestamp) NOT NULL,
    modified         timestamp with local time zone
                         DEFAULT (current_timestamp) NOT NULL
)
ENABLE ROW MOVEMENT
;

ALTER TABLE rhnKickstartPackage
    ADD CONSTRAINT rhn_kspackage_pos_uq UNIQUE (kickstart_id, position)
    USING INDEX TABLESPACE [[4m_tbs]];

ALTER TABLE rhnKickstartPackage
    ADD CONSTRAINT rhn_kspackage_name_uq UNIQUE (kickstart_id, package_name_id)
    USING INDEX TABLESPACE [[4m_tbs]];

