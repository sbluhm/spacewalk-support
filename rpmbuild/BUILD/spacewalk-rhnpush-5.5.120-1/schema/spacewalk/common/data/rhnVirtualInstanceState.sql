--
-- Copyright (c) 2008--2010 Red Hat, Inc.
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
-- data for rhnVirtualInstanceState

insert into rhnVirtualInstanceState (id, name, label) values (sequence_nextval('rhn_vis_id_seq'), 'Unknown', 'unknown');
insert into rhnVirtualInstanceState (id, name, label) values (sequence_nextval('rhn_vis_id_seq'), 'Running', 'running');
insert into rhnVirtualInstanceState (id, name, label) values (sequence_nextval('rhn_vis_id_seq'), 'Stopped', 'stopped');
insert into rhnVirtualInstanceState (id, name, label) values (sequence_nextval('rhn_vis_id_seq'), 'Crashed', 'crashed');
insert into rhnVirtualInstanceState (id, name, label) values (sequence_nextval('rhn_vis_id_seq'), 'Paused', 'paused');

