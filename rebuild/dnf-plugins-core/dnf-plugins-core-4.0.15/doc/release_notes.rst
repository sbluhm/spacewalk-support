..
  Copyright (C) 2014  Red Hat, Inc.

  This copyrighted material is made available to anyone wishing to use,
  modify, copy, or redistribute it subject to the terms and conditions of
  the GNU General Public License v.2, or (at your option) any later version.
  This program is distributed in the hope that it will be useful, but WITHOUT
  ANY WARRANTY expressed or implied, including the implied warranties of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General
  Public License for more details.  You should have received a copy of the
  GNU General Public License along with this program; if not, write to the
  Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
  02110-1301, USA.  Any Red Hat trademarks that are incorporated in the
  source code or documentation are not subject to the GNU General Public
  License and may only be used or replicated with the express permission of
  Red Hat, Inc.

##############################
Core DNF Plugins Release Notes
##############################

.. contents::

====================
4.0.15 Release Notes
====================

- Support remote files in dnf builddep
- [download] Respect repo priority (RhBug:1800342)

Bugs fixed in 4.0.15:

* :rhbug:`1800342`

====================
4.0.14 Release Notes
====================

- Fix conflict for dnf download --resolve (RhBug:1787908)
- config-manager calls parser error when without options (RhBug:1782822)
- Update reposync.py with --norepopath option
- Fix: don't open stdin if versionlock is missing (RhBug:1785563)

Bugs fixed in 4.0.14:

* :rhbug:`1787908`
* :rhbug:`1782822`
* :rhbug:`1785563`

====================
4.0.13 Release Notes
====================

- Fix: config_manager respect config file location during save
- [reposync] Fix --delete with multiple repos (RhBug:1774103)
- Redesign reposync --latest for modular system (RhBug:1775434)
- [doc] Skip creating and installing migrate documentation for Python 3+
- [config-manager] Allow use of --set-enabled without arguments (RhBug:1679213)
- [versionlock] Prevent conflicting/duplicate entries (RhBug:1782052)

Bugs fixed in 4.0.13:

* :rhbug:`1679213`
* :rhbug:`1782052`
* :rhbug:`1775434`
* :rhbug:`1774103`

====================
4.0.12 Release Notes
====================

- [reposync] Add --urls option (RhBug:1686602)
- [versionlock] Add --raw option (RhBug:1645564)
- [doc] move manpages for plugins to "dnf-PLUGIN" (RhBug:1706386)
- Add new plugin post-transaction-actions (RhBug:967264)
- [builddep] Add --skip-unavailable switch (RhBug:1628634)
- [versionlock] Don't apply excludes on @System (RhBug:1726712)
- [reposync] Ignore only modular excludes (RhBug:1750273)

Bugs fixed in 4.0.12:

* :rhbug:`967264`
* :rhbug:`1726712`
* :rhbug:`1645564`
* :rhbug:`1750273`
* :rhbug:`1686602`
* :rhbug:`1706386`

====================
4.0.11 Release Notes
====================

- [spec] Specify attributes for ghost file (RhBug: 1754463)
- download: add the --debugsource option (RhBug:1637008)
- Fix incorrect handling richdeps in buildep (RhBug:1756902)

Bugs fixed in 4.0.11:

* :rhbug:`1754463`
* :rhbug:`1637008`
* :rhbug:`1756902`

====================
4.0.10 Release Notes
====================

- debuginfo-install: Update both debuginfo and debugsource for updated package (RhBug:1586084)
- copr: Support multilib repofiles (RhBug:1393664)
- copr: Fix disable if copr instance has non-default port
- copr: Fix repoid when using subdirectories in copr project

Bugs fixed in 4.0.10:

* :rhbug:`1689645`
* :rhbug:`1676418`
* :rhbug:`1532378`
* :rhbug:`1629412`

===================
4.0.9 Release Notes
===================

- [spec] Rename dnf-utils to yum-utils
- [builddep] Report all rpm errors (RhBug:1663619,1658292,1724668)
- [config-manager] --setopt: Fix crash with "--save --dump"
- [config-manager] --setopt: Add globs support to repoid
- [config-manager] --setopt=key=value is applied only to the main config
- [config-manager] --setopt and empty list of repositories (RhBug:1702678)
- [config-manager] --setopt: Add check for existence of input repositories

Bugs fixed in 4.0.9:

* :rhbug:`1663619`
* :rhbug:`1702678`
* :rhbug:`1724668`

===================
4.0.8 Release Notes
===================

- [reposync] Enable timestamp preserving for downloaded data (RhBug:1688537)
- [reposync] Download packages from all streams (RhBug:1714788)
- Make yum-copr manpage available (RhBug:1673902)
- [needs-restarting] Add ``--reboothint`` option (RhBug:1192946) (RhBug:1639468)
- Set the cost of ``_dnf_local`` repo to 500, to make it preferred to normal repos

Bugs fixed in 4.0.8:

* :rhbug:`1192946`
* :rhbug:`1673920`
* :rhbug:`1673902`
* :rhbug:`1707552`
* :rhbug:`1714788`
* :rhbug:`1688537`

===================
4.0.7 Release Notes
===================

- Fix: copr disable command traceback (RhBug:1693551)
- [doc] state repoid as repo identifier of config-manager (RhBug:1686779)
- Fix download of src when not the latest requested (RhBug:1649627)

Bugs fixed in 4.0.7:

* :rhbug:`1693551`

===================
4.0.6 Release Notes
===================

* Use improved config parser that preserves order of data
* [leaves] Show multiply satisfied dependencies as leaves
* [download] Fix downloading an rpm from a URL (RhBug:1678582)
* [download] Fix problem with downloading src pkgs (RhBug:1649627)

===================
4.0.4 Release Notes
===================

* [download] Do not download src without ``--source`` (RhBug:1666648)

Bugs fixed in 4.0.4:

* :rhbug:`1666648`

===================
4.0.3 Release Notes
===================

* Add ``changelog`` plugin that is used for viewing package changelogs
* New option ``--metadata-path`` option for reposync plugin

Bugs fixed in 4.0.3:

* :rhbug:`1654529`

===================
4.0.2 Release Notes
===================

* Added repodif command
* copr: fix enabling Rawhide repository
* Add needs-restarting CLI shim
* [reposync] Fix traceback with --quiet option
* [versionlock] Accept more pkgspec forms

Bugs fixed in 4.0.2:

* :rhbug:`1643676`
* :rhbug:`1648649`
* :rhbug:`1644563`
* :rhbug:`1557340`
* :rhbug:`1628888`

===================
4.0.0 Release Notes
===================

* Enhance documentation
* [repoclosure] check every --pkg attribute separately
* [repoclosure] Now accepts nevra as a argument of --pkg option
* [reposync] enhancements (RhBug:1550063,1582152,1550064,1405789,1598068)
* package-cleanup: remove --oldkernels
* Download only packages with unique NEVRAs (RhBug:1612874)

Bugs fixed in 4.0.0:

* :rhbug:`1550063`
* :rhbug:`1505035`
* :rhbug:`1571622`

===================
3.0.4 Release Notes
===================

* [copr] Huge upgrade of copr plugin
* [spec] Disable building python2 modules on Fedora 30+

Bugs fixed in 3.0.4:

* :rhbug:`1626011`
* :rhbug:`1478208`

===================
3.0.3 Release Notes
===================

* [download] new option --alldeps to download all requirements

===================
3.0.2 Release Notes
===================

Bugs fixed in 3.0.2:

* :rhbug:`1603805`
* :rhbug:`1571251`

===================
3.0.1 Release Notes
===================

* Enhanced documentation

Bugs fixed in 3.0.1:

* :rhbug:`1576594`
* :rhbug:`1530081`
* :rhbug:`1547897`
* :rhbug:`1550006`
* :rhbug:`1431491`
* :rhbug:`1516857`
* :rhbug:`1499623`
* :rhbug:`1489724`

===================
2.1.5 Release Notes
===================

Bugs fixed in 2.1.5:

* :rhbug:`1498426`

===================
2.1.4 Release Notes
===================

* Added four new options for ``list`` subcommand of ``copr`` plugin

Bugs fixed in 2.1.4:

* :rhbug:`1476834`

===================
2.1.3 Release Notes
===================

Bugs fixed in 2.1.3:

* :rhbug:`1470843`
* :rhbug:`1279001`
* :rhbug:`1439514`

===================
2.1.2 Release Notes
===================

* :doc:`copr` doesn't crash anymore in some circumstances.
* :doc:`debuginfo-install` doesn't install any additional subpackages anymore,
  previously it was trying to get all dependent packages recursively and install
  debuginfo packages for them.

Bugs fixed in 2.1.2:

* :rhbug:`1322599`

===================
2.1.1 Release Notes
===================

It introduces new behavior of Versionlock plugin where it doesn't apply any excludes in non-transactional operations like `repoquery`, `list`, `info`, etc.

Bugs fixed in 2.1.1:

* :rhbug:`1458446`

===================
2.1.0 Release Notes
===================

Additional subpackage in 2.1.0:

* Added new subpackage ``dnf-utils`` that provides binaries originaly provided by ``yum-utils``.

Bugs fixed in 2.1.0:

* :rhbug:`1381917`

===================
2.0.0 Release Notes
===================

* Added ``DEBUG`` plugin from dnf-plugins-extras
* Added ``LEAVES`` plugin from dnf-plugins-extras
* Added ``LOCAL`` plugin from dnf-plugins-extras
* Added ``MIGRATE`` plugin from dnf-plugins-extras
* Added ``NEEDS RESTARTING`` plugin from dnf-plugins-extras
* Added ``REPOCLOSURE`` plugin from dnf-plugins-extras
* Added ``REPOGRAPH`` plugin from dnf-plugins-extras
* Added ``REPOMANAGE`` plugin from dnf-plugins-extras
* Added ``SHOW LEAVES`` plugin from dnf-plugins-extras
* Added ``VERSIONLOCK`` plugin from dnf-plugins-extras

===================
1.1.0 Release Notes
===================

* Updated translations
* :doc:`builddep` doesn't check GPG key of src.rpm anymore
* :doc:`builddep` installs dependencies by provides
* :doc:`download` with ``--resolve`` now downloads all needed packages for transaction

Bugs fixed in 1.1.0:

* :rhbug:`1429087`
* :rhbug:`1431486`
* :rhbug:`1332830`
* :rhbug:`1276611`

===================
1.0.2 Release Notes
===================

Newly implemented :doc:`download` options ``--url`` and ``--urlprotocol``.

Bugs fixed in 1.0.2:

* :rhbug:`1250115`

===================
1.0.1 Release Notes
===================

Minor changes in builddep: print errors from RPM SPEC parser

===================
1.0.0 Release Notes
===================

`Repoquery  <https://dnf.readthedocs.org/en/latest/command_ref.html#repoquery_command-label>`_ and
`protected_packages <dnf.readthedocs.io/en/latest/conf_ref.html>`_ plugins were integrated into DNF.

Bugs fixed in 1.0.0:

* :rhbug:`1361003`
* :rhbug:`1360752`
* :rhbug:`1350604`
* :rhbug:`1325350`
* :rhbug:`1303117`
* :rhbug:`1193823`
* :rhbug:`1260986`

====================
0.1.21 Release Notes
====================

Bugfixes, internal improvements.

Bugs fixed in 0.1.21:

* :rhbug:`1335959`
* :rhbug:`1279538`
* :rhbug:`1303311`

====================
0.1.20 Release Notes
====================

Small fixes in COPR plugin, added ``get_reposdir`` function to dnfpluginscore lib.

====================
0.1.18 Release Notes
====================

Changed COPR server adress to the new one.

====================
0.1.17 Release Notes
====================

Added configuration file for :doc:`debuginfo-install`.


Bugs fixed in 0.1.17:

* :rhbug:`1024701`
* :rhbug:`1302214`

====================
0.1.16 Release Notes
====================

Documented `DNF repoquery <https://dnf.readthedocs.org/en/latest/command_ref.html#repoquery_command-label>`_ options ``--unneeded`` and ``--recent``.

Bugs fixed in 0.1.16:

* :rhbug:`1297511`
* :rhbug:`1292475`

====================
0.1.15 Release Notes
====================

Newly implemented :doc:`download` options ``--resolve`` and ``--debuginfo``.

Improved the start-up time of bash completion.

Reviewed documentation.

Bugs fixed in 0.1.15:

* :rhbug:`1283448`
* :rhbug:`1253237`

=====================
 0.1.14 Release Notes
=====================

Bugs fixed in 0.1.14:

* :rhbug:`1231572`
* :rhbug:`1265210`
* :rhbug:`1280416`
* :rhbug:`1270091`
* :rhbug:`1272936`

=====================
 0.1.13 Release Notes
=====================

Kickstart plugin has been moved to `dnf plugins extras`_ as a separate ``python-dnf-plugins-extras-kickstart`` package.

Bugs fixed in 0.1.13:

* :rhbug:`1267808`
* :rhbug:`1264125`
* :rhbug:`1265622`
* :rhbug:`1159614`

=====================
 0.1.12 Release Notes
=====================

Added support of globs to ``--whatrequires`` and ``--whatprovides`` options.

Bugs fixed in 0.1.12:

* :rhbug:`1249073`

=====================
 0.1.11 Release Notes
=====================

Option ``--arch`` now accepts more than one architecture.

Introduced select options ``--available``, ``--extras``, ``--installed``, ``--upgrades``.

Added ability to use weak dependencies query options in combination with ``--tree`` switch.

Bugs fixed in 0.1.11:

* :rhbug:`1250114`
* :rhbug:`1186381`
* :rhbug:`1225784`
* :rhbug:`1233728`
* :rhbug:`1199601`
* :rhbug:`1156778`

=====================
 0.1.10 Release Notes
=====================

:doc:`builddep` was extended by newly added options ``--srpm`` and ``--spec`` for specifying the input file.

Implemented ``remove`` command in :doc:`copr` plugin.

Bugs fixed in 0.1.10:

* :rhbug:`1226663`
* :rhbug:`1184930`
* :rhbug:`1234099`
* :rhbug:`1241126`
* :rhbug:`1218299`
* :rhbug:`1241135`
* :rhbug:`1244125`


====================
 0.1.9 Release Notes
====================

`DNF repoquery <https://dnf.readthedocs.org/en/latest/command_ref.html#repoquery_command-label>`_ was extended by newly added select options ``--srpm``, ``--alldeps``
and query option ``--tree``.

Bugs fixed in 0.1.9:

* :rhbug:`1128425`
* :rhbug:`1186382`
* :rhbug:`1228693`
* :rhbug:`1186689`
* :rhbug:`1227190`

====================
 0.1.8 Release Notes
====================

This release fixes only packaging issues.

====================
 0.1.7 Release Notes
====================

All occurrences of `repoid` option were replaced by `repo` to unified repository specification in plugins.

:doc:`builddep` now accepts packages from repositories as arguments and allows users
to define RPM macros used during spec files parsing via `-D` option.

Three new options were added to `DNF repoquery <https://dnf.readthedocs.org/en/latest/command_ref.html#repoquery_command-label>`_: `latest-limit`, `unsatisfied` and `resolve`.

Bugs fixed in 0.1.7:

* :rhbug:`1215154`
* :rhbug:`1074585`
* :rhbug:`1156487`
* :rhbug:`1208773`
* :rhbug:`1186948`

====================
 0.1.6 Release Notes
====================

Newly implemented :doc:`config_manager` plugin.

`DNF repoquery <https://dnf.readthedocs.org/en/latest/command_ref.html#repoquery_command-label>`_ now accepts `<pkg-spec>`.

Bugs fixed in 0.1.6:

* :rhbug:`1208399`
* :rhbug:`1194725`
* :rhbug:`1198442`
* :rhbug:`1193047`
* :rhbug:`1196952`
* :rhbug:`1171046`
* :rhbug:`1179366`

====================
 0.1.5 Release Notes
====================

:doc:`builddep` accepts also `nosrc.rpm` package.

`DNF repoquery <https://dnf.readthedocs.org/en/latest/command_ref.html#repoquery_command-label>`_ adds `--list` switch to show files the package contains.

Bugs fixed in 0.1.5:

* :rhbug:`1187773`
* :rhbug:`1178239`
* :rhbug:`1166126`
* :rhbug:`1155211`

====================
 0.1.4 Release Notes
====================

Provides :doc:`needs_restarting` and :doc:`reposync`.

Bugs fixed in 0.1.4:

* :rhbug:`1139738`
* :rhbug:`1144003`

====================
 0.1.3 Release Notes
====================

Added info switch to `DNF repoquery <https://dnf.readthedocs.org/en/latest/command_ref.html#info_repoquery-label>`_

Bugs fixed in 0.1.3:

* :rhbug:`1135984`
* :rhbug:`1134378`
* :rhbug:`1123886`

====================
 0.1.2 Release Notes
====================

Bugs fixed in 0.1.2:

* :rhbug:`1108321`
* :rhbug:`1116389`
* :rhbug:`1118809`

====================
 0.1.1 Release Notes
====================

Provides :doc:`protected_packages` and a bugfix to the Copr plugin.

Bugs fixed in 0.1.1:

* :rhbug:`1049310`
* :rhbug:`1104088`
* :rhbug:`1111855`

====================
 0.1.0 Release Notes
====================

This release provides the `DNF repoquery <https://dnf.readthedocs.org/en/latest/command_ref.html#repoquery_command-label>`_ and a bugfix for the :doc:`builddep`.

Bugs fixed for 0.1.0:

* :rhbug:`1045078`
* :rhbug:`1103906`


.. _dnf plugins extras: http://dnf-plugins-extras.readthedocs.org/
