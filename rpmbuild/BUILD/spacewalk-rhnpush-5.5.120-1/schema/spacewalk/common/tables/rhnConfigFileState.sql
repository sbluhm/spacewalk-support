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


CREATE TABLE rhnConfigFileState
(
    id        NUMBER NOT NULL
                  CONSTRAINT rhn_cfstate_id_pk PRIMARY KEY
                  USING INDEX TABLESPACE [[2m_tbs]],
    label     VARCHAR2(32) NOT NULL,
    name      VARCHAR2(256) NOT NULL,
    created   timestamp with local time zone
                  DEFAULT (current_timestamp) NOT NULL,
    modified  timestamp with local time zone
                  DEFAULT (current_timestamp) NOT NULL
)
ENABLE ROW MOVEMENT
;

CREATE UNIQUE INDEX rhn_cfstate_label_id_uq
    ON rhnConfigFileState (label, id)
    TABLESPACE [[4m_tbs]];

CREATE SEQUENCE rhn_cfstate_id_seq;

