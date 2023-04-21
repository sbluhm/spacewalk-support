--
-- Copyright (c) 2010--2012 Red Hat, Inc.
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


CREATE TABLE rhnPackageUpgradeArchCompat
(
    package_arch_id   NUMBER NOT NULL
                         CONSTRAINT rhn_puac_paid_fk
                             REFERENCES rhnPackageArch (id),
    package_upgrade_arch_id NUMBER NOT NULL
                         CONSTRAINT rhn_puac_pauid_fk
                             REFERENCES rhnPackageArch (id),
    created          timestamp with local time zone
                         DEFAULT (current_timestamp) NOT NULL,
    modified         timestamp with local time zone
                         DEFAULT (current_timestamp) NOT NULL
)
ENABLE ROW MOVEMENT
;

CREATE UNIQUE INDEX rhn_puac_pa_pua_uq
    ON rhnPackageUpgradeArchCompat (package_arch_id, package_upgrade_arch_id)
    TABLESPACE [[64k_tbs]];
