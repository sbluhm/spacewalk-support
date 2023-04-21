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


CREATE TABLE rhnErrataQueue
(
    errata_id    NUMBER NOT NULL
                     CONSTRAINT rhn_equeue_eid_fk
                         REFERENCES rhnErrata (id)
                         ON DELETE CASCADE,
    channel_id   NUMBER NOT NULL
                     CONSTRAINT rhn_equeue_cid_fk
                         REFERENCES rhnChannel(id)
                         ON DELETE CASCADE,
    next_action  timestamp with local time zone,
    created      timestamp with local time zone
                     DEFAULT (current_timestamp) NOT NULL,
    modified     timestamp with local time zone
                     DEFAULT (current_timestamp) NOT NULL
)
ENABLE ROW MOVEMENT
;

CREATE INDEX rhn_equeue_eid_idx
    ON rhnErrataQueue (errata_id)
    TABLESPACE [[4m_tbs]];

CREATE INDEX rhn_equeue_na_eid_idx
    ON rhnErrataQueue (next_action, errata_id)
    TABLESPACE [[8m_tbs]];


