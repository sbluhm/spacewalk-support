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


CREATE TABLE rhnUserServerGroupPerms
(
    user_id          NUMBER NOT NULL
                         CONSTRAINT rhn_usgp_user_fk
                             REFERENCES web_contact (id)
                             ON DELETE CASCADE,
    server_group_id  NUMBER NOT NULL
                         CONSTRAINT rhn_usgp_server_fk
                             REFERENCES rhnServerGroup (id)
                             ON DELETE CASCADE,
    created          timestamp with local time zone
                         DEFAULT (current_timestamp) NOT NULL,
    modified         timestamp with local time zone
                         DEFAULT (current_timestamp) NOT NULL
)
ENABLE ROW MOVEMENT
;

CREATE UNIQUE INDEX rhn_usgp_u_sg_p_uq
    ON rhnUserServerGroupPerms (user_id, server_group_id)
    TABLESPACE [[4m_tbs]];

CREATE INDEX rhn_usgp_sg_idx
    ON rhnUserServerGroupPerms (server_group_id)
    TABLESPACE [[4m_tbs]]
    NOLOGGING;

