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


CREATE TABLE web_user_contact_permission
(
    web_user_id  NUMBER NOT NULL
                     CONSTRAINT contperm_wbuserid_fk
                         REFERENCES web_contact (id)
                         ON DELETE CASCADE,
    email        CHAR(1)
                     DEFAULT ('N')
                     CONSTRAINT wucp_email_ck
                         CHECK (email in ('Y','N')),
    mail         CHAR(1)
                     DEFAULT ('N')
                     CONSTRAINT wucp_mail_ck
                         CHECK (mail in ('Y','N')),
    call         CHAR(1)
                     DEFAULT ('N')
                     CONSTRAINT wucp_call_ck
                         CHECK (call in ('Y','N')),
    fax          CHAR(1)
                     DEFAULT ('N')
                     CONSTRAINT wucp_fax_ck
                         CHECK (fax in ('Y','N')),
    created      timestamp with local time zone
                     DEFAULT (current_timestamp) NOT NULL,
    modified     timestamp with local time zone
                     DEFAULT (current_timestamp) NOT NULL
)
ENABLE ROW MOVEMENT
;

