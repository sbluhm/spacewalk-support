%define move_yum_conf_back 1
%define auto_sitelib 1
%define yum_updatesd 0
%define disable_check 0
%define yum_cron_systemd 1

%if 0%{?rhel} <= 6
# rhel-6 doesn't have the systemd stuff...
%define yum_cron_systemd 0
%endif

%if %{auto_sitelib}

%{!?python_sitelib: %define python_sitelib %(python -c "from distutils.sysconfig import get_python_lib; print get_python_lib()")}

%else
%define python_sitelib /usr/lib/python?.?/site-packages
%endif

# We always used /usr/lib here, even on 64bit ... so it's a bit meh.
%define yum_pluginslib   /usr/lib/yum-plugins
%define yum_pluginsshare /usr/share/yum-plugins

# disable broken /usr/lib/rpm/brp-python-bytecompile
%define __os_install_post %{nil}
%if 0%{?fedora} >= 19 || 0%{?rhel} >= 7
%define compdir %{_datadir}/bash-completion/completions
%else
%define compdir %{_sysconfdir}/bash_completion.d
%endif

Summary: RPM package installer/updater/manager
Name: yum
Version: 3.4.3
Release: 163%{?dist}
License: GPLv2+
Group: System Environment/Base
Source0: http://yum.baseurl.org/download/3.4/%{name}-%{version}.tar.gz
Source1: yum.conf.centos
Source2: yum-updatesd.conf.fedora
Patch1: yum-distro-configs.patch
Patch5: geode-arch.patch
Patch6: yum-HEAD.patch
Patch7: yum-ppc64-preferred.patch
Patch20: yum-manpage-files.patch
Patch21: yum-completion-helper.patch

# rhel-7.0
Patch30: BZ-801067-remove-kernel-modules-from-installonly.patch
patch31: BZ-1002977-use-the-provide-version.patch
patch32: BZ-1033416-yum-error-on-non-us-locale.patch
patch33: BZ-1050902-manpage-formatting-errrors.patch
patch34: BZ-1052994-yum-cron-install-unsigned-packages.patch
patch35: BZ-1041395-depsolve-loop-limit.patch
patch36: BZ-1053289-misc-perf+UI+simple-bug+docs-fixes.patch
patch37: BZ-1052436-group-bundle-pre-f20-fixes.patch
patch38: BZ-1040619-yum-cron-reporting.patch
patch39: BZ-1062959-add-fs-command.patch
patch40: BZ-1052436-group-bundle-docs.patch
patch41: BZ-1058297-remove-del-for-weird-anaconda-C-NULL-exception.patch

# rhel-7.1
Patch100: BZ-1130939-dont-create-lockdir-directories.patch
Patch101: BZ-1113395-verify-permissions-mask.patch
Patch102: BZ-1097383-usr-readonly.patch
Patch103: BZ-1095161-setopt-spaces-handling.patch
Patch104: BZ-1095157-traceback-when-empty-history.patch
Patch106: BZ-1138205-needs-restarting.patch
Patch107: BZ-1102585-variable-substitution.patch
Patch108: BZ-1096147-history-search-crash.patch
Patch109: BZ-1087911-update-minimal-manpage.patch
Patch110: BZ-1063181-upgrades-for-install-only.patch
Patch111: BZ-1147992-debuginfo-install-dolock-exception.patch
Patch112: BZ-1095146-file-uris-normpath.patch

# rhel-7.2
Patch150: BZ-1192239-update-minimal.patch
Patch151: BZ-1212514-not-enough-space.patch
Patch152: BZ-1212506-running-kernel-epoch.patch
Patch153: BZ-1168385-group-conditionals-deselect.patch
Patch154: BZ-1182096-yum-cron-conf-upgrade-minimal.patch
Patch155: BZ-1212519-exclude-installed.patch
Patch156: BZ-1063177-xml-traceback.patch
Patch157: BZ-1211384-yum-grouplist-headers.patch
Patch158: BZ-1193871-updateinfo-notice-when-arch-changed.patch
Patch159: BZ-1047793-lvm-snapshot.patch
Patch160: BZ-1168120-manpage.patch
Patch161: BZ-1182075-yum-security-manpage.patch
Patch162: BZ-1199976-kbase-articles.patch
Patch163: BZ-1188960-API-missing-requires.patch
Patch164: BZ-1233152-pvm-api-lv_attr.patch
Patch165: BZ-1244119-fssnapshot-automatic-percentage-manpage.patch
Patch166: BZ-1259837-igroups-empty-lines.patch

# rhel-7.3
Patch200: BZ-1267234-groupinstall-fail-on-non-existent.patch
Patch201: BZ-1274211-skip-missing-names.patch
Patch202: BZ-1183669-corrupt-cache.patch
Patch203: BZ-1235623-new-provides-realpath-file-search.patch
Patch204: BZ-1292160-security-lists-wrong-arch-updates.patch
Patch205: BZ-1267897-exclude-dups-from-security-updates.patch
Patch206: BZ-1292150-updateinfo-list-available.patch
Patch207: BZ-1293670-proxy.patch
Patch208: BZ-1291745-query-install-excludes.patch
Patch209: BZ-1293378-ftp-disable-epsv.patch
Patch210: BZ-1272058-arches.patch
Patch211: BZ-1279483-hidden-groups-manpage.patch
Patch212: BZ-1281593-yum-fs-vars.patch
Patch213: BZ-1306142-allow-older-installonly-deps.patch
Patch214: BZ-1321651-repoinfo-add-metadata-expire-filter.patch
Patch215: BZ-1202680-handle-non-ascii-email.patch
Patch216: BZ-1168121-fssnapshot-manpage-fix.patch
Patch217: BZ-1004853-yum-cron-handle-empty-transaction.patch
Patch218: BZ-1309676-fs-command-help-fix.patch
Patch219: BZ-1294789-yum-cron-fix-update_cmd.patch
Patch220: BZ-1292087-history-hash-crash.patch
Patch221: BZ-1234967-handle-invalid-yumdb.patch
Patch222: BZ-1208803-autosavets.patch
Patch223: BZ-1186690-compare_providers_priorities.patch
Patch224: BZ-1330423-skipbroken-installonly-limit-fix.patch
Patch225: BZ-1195745-failed-repo-message.patch
Patch226: BZ-1327962-conduit-typo.patch
Patch227: BZ-1328023-updateinfo-traceback.patch
Patch228: BZ-1293513-compdir.patch
Patch229: BZ-1065380-updateinfo-strip-respin.patch
Patch230: BZ-1175309-enable-repos-instruction.patch
Patch231: BZ-1337105-add-lazy-packages-caching-opt.patch
Patch232: BZ-1348995-ship-comps-rng-schema.patch
Patch233: BZ-1339168-yum-cron-conf-typo.patch
Patch234: BZ-1330670-system-name-email-from-cron.patch
Patch235: BZ-1347813-security-updates-count.patch
Patch236: BZ-1335250-fssnapshot-handle-lvm-errors.patch
Patch237: BZ-1356797-silent-exception.patch
Patch238: BZ-1377328-_metadata_cache_req.patch

# rhel-7.4
Patch250: BZ-1389816-include-repoid-in-timestamp-error.patch
Patch251: BZ-1369389-dont-recommend-makecache-if-running.patch
Patch252: BZ-1194915-add-logging-for-bad-notice-dupes.patch
Patch253: BZ1410326-Fix-for-history-package-list.patch
Patch254: BZ-1399628-updateinfo-fix-wrong-pkg-count.patch
Patch255: BZ-1391507-fix-filelist-queries-for-dup-pkgs.patch
Patch256: BZ-1343690-add-payload-gpgcheck-opt.patch
Patch257: BZ-1357083-clean-all-add-hint-rm-rf.patch
Patch258: BZ-1370134-yum-check-ignore-self-conflicts.patch
Patch259: BZ-1352585-detect-installed-provide.patch
Patch260: BZ-1397829-fix-reget-simple-md-fnames.patch

# rhel-7.5
Patch280: BZ-1287610-fips-dont-pollute-stderr.patch
Patch281: BZ-1358492-installonly-kernel.patch
Patch282: BZ-1175315-dont-require-enabled-repos-for-url.patch
Patch283: BZ-1386597-obsoletes-man-page.patch
Patch284: BZ-1411575-manpage-typo.patch
Patch285: BZ-1458841-preload-shared-libs.patch
Patch286: BZ-1451817-docs-improve-payload-gpgcheck-opt.patch
Patch287: BZ-1361609-improve-exactarchlist-opt.patch
Patch288: BZ-1432319-add-usercache-opt.patch
Patch289: BZ-1411692-docs-conf-var-naming-rules.patch
Patch290: BZ-1278333-yum-shell-support-exit-status.patch

# rhel-7.6
Patch310: BZ-1520454-gpgkey-retry-broken-redirects.patch
Patch311: BZ-1509831-baseurl-clarify-multiple-urls.patch
Patch312: BZ-1528608-updateinfo-preload-pkgsack.patch
Patch313: BZ-1477574-update-honor-multilib-policy-for-obsoletes.patch
Patch314: BZ-1481220-print-disk-usage-on-yum-clean-all.patch
Patch315: BZ-1480065-depsolve-filter-conflicting-provider.patch
Patch316: BZ-1506890-logrotate-change-size-to-maxsize.patch

# rhel-7.7
Patch340: BZ-1410234-downloadonly-unlink-tmp-files.patch
Patch341: BZ-1645173-clean-all-disk-usage-fixes.patch
Patch342: BZ-1600383-save-ts-no-str-concat.patch
Patch343: BZ-1510491-fixup-yumdb-validator.patch

Patch1000: centos-branding-yum.patch

URL: http://yum.baseurl.org/
BuildArchitectures: noarch
BuildRequires: python
BuildRequires: gettext
BuildRequires: intltool
# This is really CheckRequires ...
BuildRequires: python-nose
BuildRequires: python >= 2.4
BuildRequires: rpm-python, rpm >= 0:4.4.2
BuildRequires: python-iniparse
BuildRequires: python-sqlite
BuildRequires: python-urlgrabber >= 3.10-8
BuildRequires: yum-metadata-parser >= 1.1.0
BuildRequires: pygpgme
# End of CheckRequires
Conflicts: pirut < 1.1.4
Requires: python >= 2.4
Requires: yum-plugin-fastestmirror
Requires: rpm-python, rpm >= 0:4.11.3-22
Requires: python-iniparse
Requires: python-sqlite
Requires: python-urlgrabber >= 3.10-8
Requires: yum-metadata-parser >= 1.1.0
Requires: pygpgme
# rawhide is >= 0.5.3-7.fc18 ... as this is added.
Requires: pyliblzma
# Not really a suggests anymore, due to metadata using it.
Requires: pyxattr
# Suggests, needed for yum fs diff
Requires: diffutils
Requires: cpio


Conflicts: rpm >= 5-0
# Zif is a re-implementation of yum in C, however:
#
# 1. There is no co-operation/etc. with us.
# 2. It touches our private data directly.
#
# ...both of which mean that even if there were _zero_ bugs in zif, we'd
# never be able to change anything after the first user started using it. And
# of course:
#
# 3. Users will never be able to tell that it isn't weird yum bugs, when they
# hit them (and we'll probably never be able to debug them, without becoming
# zif experts).
#
# ...so we have two sane choices: i) Conflict with it. 2) Stop developing yum.
#
#  Upstream says that #2 will no longer be true after this release.
Conflicts: zif <= 0.1.3-3.fc15

Obsoletes: yum-skip-broken <= 1.1.18
Provides: yum-skip-broken = 1.1.18.yum
Obsoletes: yum-basearchonly <= 1.1.9
Obsoletes: yum-plugin-basearchonly <= 1.1.9
Provides: yum-basearchonly = 1.1.9.yum
Provides: yum-plugin-basearchonly = 1.1.9.yum
Obsoletes: yum-allow-downgrade < 1.1.20-0
Obsoletes: yum-plugin-allow-downgrade < 1.1.22-0
Provides: yum-allow-downgrade = 1.1.20-0.yum
Provides: yum-plugin-allow-downgrade = 1.1.22-0.yum
Obsoletes: yum-plugin-protect-packages < 1.1.27-0
Provides: yum-protect-packages = 1.1.27-0.yum
Provides: yum-plugin-protect-packages = 1.1.27-0.yum
Obsoletes: yum-plugin-download-order <= 0.2-2
Obsoletes: yum-plugin-downloadonly <= 1.1.31-7.fc18
Provides: yum-plugin-downloadonly = 3.4.3-44.yum
Obsoletes: yum-presto < 3.4.3-66.yum
Provides: yum-presto = 3.4.3-66.yum
Obsoletes: yum-plugin-security < 1.1.32
Provides: yum-plugin-security = 3.4.3-84.yum
BuildRoot: %{_tmppath}/%{name}-%{version}-%{release}-root-%(%{__id_u} -n)


%description
Yum is a utility that can check for and automatically download and
install updated RPM packages. Dependencies are obtained and downloaded 
automatically, prompting the user for permission as necessary.

%package updatesd
Summary: Update notification daemon
Group: Applications/System
Requires: yum = %{version}-%{release}
Requires: dbus-python
Requires: pygobject2
Requires(preun): /sbin/chkconfig
Requires(post): /sbin/chkconfig
Requires(preun): /sbin/service
Requires(post): /sbin/service
Requires(postun): /sbin/chkconfig
Requires(postun): /sbin/service


%description updatesd
yum-updatesd provides a daemon which checks for available updates and 
can notify you when they are available via email, syslog or dbus. 

%package cron
Summary: Files needed to run yum updates as a cron job
Group: System Environment/Base
Requires: yum >= 3.4.3-84 cronie crontabs findutils
%if %{yum_cron_systemd}
BuildRequires: systemd-units
Requires(post): systemd
Requires(preun): systemd
Requires(postun): systemd
%else
Requires(post): /sbin/chkconfig
Requires(post): /sbin/service
Requires(preun): /sbin/chkconfig
Requires(preun): /sbin/service
Requires(postun): /sbin/service
%endif

%description cron
These are the files needed to run yum updates as a cron job.
Install this package if you want auto yum updates nightly via cron.


%prep
%setup -q
%patch5 -p1
%patch6 -p1
%patch7 -p1
%patch20 -p1
%patch21 -p1

# rhel-7.0
%patch30 -p1
%patch31 -p1
%patch32 -p1
%patch33 -p1
%patch34 -p1
%patch35 -p1
%patch36 -p1
%patch37 -p1
%patch38 -p1
%patch39 -p1
%patch40 -p1
%patch41 -p1

# rhel-7.1
%patch100 -p1
%patch101 -p1
%patch102 -p1
%patch103 -p1
%patch104 -p1
%patch106 -p1
%patch107 -p1
%patch108 -p1
%patch109 -p1
%patch110 -p1
%patch111 -p1
%patch112 -p1

# rhel-7.2
%patch150 -p1
%patch151 -p1
%patch152 -p1
%patch153 -p1
%patch154 -p1
%patch155 -p1
%patch156 -p1
%patch157 -p1
%patch158 -p1
%patch159 -p1
%patch160 -p1
%patch161 -p1
%patch162 -p1
%patch163 -p1
%patch164 -p1
%patch165 -p1
%patch166 -p1

# rhel-7.3
%patch200 -p1
%patch201 -p1
%patch202 -p1
%patch203 -p1
%patch204 -p1
%patch205 -p1
%patch206 -p1
%patch207 -p1
%patch208 -p1
%patch209 -p1
%patch210 -p1
%patch211 -p1
%patch212 -p1
%patch213 -p1
%patch214 -p1
%patch215 -p1
%patch216 -p1
%patch217 -p1
%patch218 -p1
%patch219 -p1
%patch220 -p1
%patch221 -p1
%patch222 -p1
%patch223 -p1
%patch224 -p1
%patch225 -p1
%patch226 -p1
%patch227 -p1
%patch228 -p1
%patch229 -p1
%patch230 -p1
%patch231 -p1
%patch232 -p1
%patch233 -p1
%patch234 -p1
%patch235 -p1
%patch236 -p1
%patch237 -p1
%patch238 -p1

# rhel-7.4
%patch250 -p1
%patch251 -p1
%patch252 -p1
%patch253 -p1
%patch254 -p1
%patch255 -p1
%patch256 -p1
%patch257 -p1
%patch258 -p1
%patch259 -p1
%patch260 -p1

# rhel-7.5
%patch280 -p1
%patch281 -p1
%patch282 -p1
%patch283 -p1
%patch284 -p1
%patch285 -p1
%patch286 -p1
%patch287 -p1
%patch288 -p1
%patch289 -p1
%patch290 -p1

# rhel-7.6
%patch310 -p1
%patch311 -p1
%patch312 -p1
%patch313 -p1
%patch314 -p1
%patch315 -p1
%patch316 -p1

# rhel-7.7
%patch340 -p1
%patch341 -p1
%patch342 -p1
%patch343 -p1

%patch1000 -p1

# Do distro config. changes after everything else.
%patch1 -p1

%build
make

%if !%{disable_check}
%check
make check
%endif


%install
[ "$RPM_BUILD_ROOT" != "/" ] && rm -rf $RPM_BUILD_ROOT

%if %{yum_cron_systemd}
INIT=systemd
%else
INIT=sysv
%endif

make DESTDIR=$RPM_BUILD_ROOT UNITDIR=%{_unitdir} INIT=$INIT COMPDIR=%{compdir} install

install -m 644 %{SOURCE1} $RPM_BUILD_ROOT/%{_sysconfdir}/yum.conf
mkdir -p $RPM_BUILD_ROOT/%{_sysconfdir}/yum/pluginconf.d $RPM_BUILD_ROOT/%{yum_pluginslib}
mkdir -p $RPM_BUILD_ROOT/%{yum_pluginsshare}

%if %{move_yum_conf_back}
# for now, move repodir/yum.conf back
mv $RPM_BUILD_ROOT/%{_sysconfdir}/yum/repos.d $RPM_BUILD_ROOT/%{_sysconfdir}/yum.repos.d
rm -f $RPM_BUILD_ROOT/%{_sysconfdir}/yum/yum.conf
%endif

%if %{yum_updatesd}
echo Keeping local yum-updatesd
%else

# yum-updatesd has moved to the separate source version
rm -f $RPM_BUILD_ROOT/%{_sysconfdir}/yum/yum-updatesd.conf 
rm -f $RPM_BUILD_ROOT/%{_sysconfdir}/rc.d/init.d/yum-updatesd
rm -f $RPM_BUILD_ROOT/%{_sysconfdir}/dbus-1/system.d/yum-updatesd.conf
rm -f $RPM_BUILD_ROOT/%{_sbindir}/yum-updatesd
rm -f $RPM_BUILD_ROOT/%{_mandir}/man*/yum-updatesd*
rm -f $RPM_BUILD_ROOT/%{_datadir}/yum-cli/yumupd.py*

%endif

# Ghost files:
mkdir -p $RPM_BUILD_ROOT/var/lib/yum/history
mkdir -p $RPM_BUILD_ROOT/var/lib/yum/plugins
mkdir -p $RPM_BUILD_ROOT/var/lib/yum/yumdb
touch $RPM_BUILD_ROOT/var/lib/yum/uuid

# rpmlint bogus stuff...
chmod +x $RPM_BUILD_ROOT/%{_datadir}/yum-cli/*.py
chmod +x $RPM_BUILD_ROOT/%{python_sitelib}/yum/*.py
chmod +x $RPM_BUILD_ROOT/%{python_sitelib}/rpmUtils/*.py

%find_lang %name

%if %{yum_cron_systemd}
# Remove the yum-cron sysV stuff to make rpmbuild happy..
rm -f $RPM_BUILD_ROOT/%{_sysconfdir}/rc.d/init.d/yum-cron
%else
# Remove the yum-cron systemd stuff to make rpmbuild happy..
rm -f $RPM_BUILD_ROOT/%{_unitdir}/yum-cron.service
%endif

%clean
[ "$RPM_BUILD_ROOT" != "/" ] && rm -rf $RPM_BUILD_ROOT


%if %{yum_updatesd}
%post updatesd
/sbin/chkconfig --add yum-updatesd
/sbin/service yum-updatesd condrestart >/dev/null 2>&1
exit 0

%preun updatesd
if [ $1 = 0 ]; then
 /sbin/chkconfig --del yum-updatesd
 /sbin/service yum-updatesd stop >/dev/null 2>&1
fi
exit 0
%endif

%post cron

%if %{yum_cron_systemd}
#systemd_post yum-cron.service
#  Do this manually because it's a fake service for a cronjob, and cronjobs
# are default on atm. This may change in the future.
if [ $1 = 1 ]; then
 systemctl enable yum-cron >/dev/null 2>&1
else
#  Note that systemctl preset is being run here ... but _only_ on initial
# install. So try this...

if [ -f /var/lock/subsys/yum-cron -a -f /etc/rc.d/init.d/yum-cron ]; then
 systemctl enable yum-cron >/dev/null 2>&1
fi
fi

# Also note:
#  systemctl list-unit-files | fgrep yum-cron
%else
# SYSV init post cron
# Make sure chkconfig knows about the service
/sbin/chkconfig --add yum-cron
# if an upgrade:
if [ "$1" -ge "1" ]; then
# if there's a /etc/rc.d/init.d/yum file left, assume that there was an
# older instance of yum-cron which used this naming convention.  Clean 
# it up, do a conditional restart
 if [ -f /etc/init.d/yum ]; then 
# was it on?
  /sbin/chkconfig yum
  RETVAL=$?
  if [ $RETVAL = 0 ]; then
# if it was, stop it, then turn on new yum-cron
   /sbin/service yum stop 1> /dev/null 2>&1
   /sbin/service yum-cron start 1> /dev/null 2>&1
   /sbin/chkconfig yum-cron on
  fi
# remove it from the service list
  /sbin/chkconfig --del yum
 fi
fi 
exit 0
%endif

%preun cron
%if %{yum_cron_systemd}
%systemd_preun yum-cron.service
%else
# SYSV init preun cron
# if this will be a complete removeal of yum-cron rather than an upgrade,
# remove the service from chkconfig control
if [ $1 = 0 ]; then
 /sbin/chkconfig --del yum-cron
 /sbin/service yum-cron stop 1> /dev/null 2>&1
fi
exit 0
%endif

%postun cron
%if %{yum_cron_systemd}
%systemd_postun_with_restart yum-cron.service
%else
# SYSV init postun cron

# If there's a yum-cron package left after uninstalling one, do a
# conditional restart of the service
if [ "$1" -ge "1" ]; then
 /sbin/service yum-cron condrestart 1> /dev/null 2>&1
fi
exit 0
%endif


%files -f %{name}.lang
%defattr(-, root, root, -)
%doc README AUTHORS COPYING TODO INSTALL ChangeLog PLUGINS docs/comps.rng
%if %{move_yum_conf_back}
%config(noreplace) %{_sysconfdir}/yum.conf
%dir %{_sysconfdir}/yum.repos.d
%else
%config(noreplace) %{_sysconfdir}/yum/yum.conf
%dir %{_sysconfdir}/yum/repos.d
%endif
%config(noreplace) %{_sysconfdir}/yum/version-groups.conf
%dir %{_sysconfdir}/yum
%dir %{_sysconfdir}/yum/protected.d
%dir %{_sysconfdir}/yum/fssnap.d
%dir %{_sysconfdir}/yum/vars
%config(noreplace) %{_sysconfdir}/logrotate.d/%{name}
%if 0%{?fedora} >= 19 || 0%{?rhel} >= 7
%(dirname %{compdir})
%else
%{compdir}
%endif
%dir %{_datadir}/yum-cli
%{_datadir}/yum-cli/*
%exclude %{_datadir}/yum-cli/completion-helper.py?
%if %{yum_updatesd}
%exclude %{_datadir}/yum-cli/yumupd.py*
%endif
%{_bindir}/yum
%{python_sitelib}/yum
%{python_sitelib}/rpmUtils
%dir /var/cache/yum
%dir /var/lib/yum
%ghost /var/lib/yum/uuid
%ghost /var/lib/yum/history
%ghost /var/lib/yum/plugins
%ghost /var/lib/yum/yumdb
%{_mandir}/man*/yum.*
%{_mandir}/man*/yum-shell*
# plugin stuff
%dir %{_sysconfdir}/yum/pluginconf.d 
%dir %{yum_pluginslib}
%dir %{yum_pluginsshare}

%files cron
%defattr(-,root,root)
%doc COPYING
%{_sysconfdir}/cron.daily/0yum-daily.cron
%{_sysconfdir}/cron.hourly/0yum-hourly.cron
%config(noreplace) %{_sysconfdir}/yum/yum-cron.conf
%config(noreplace) %{_sysconfdir}/yum/yum-cron-hourly.conf
%if %{yum_cron_systemd}
%{_unitdir}/yum-cron.service
%else
%{_sysconfdir}/rc.d/init.d/yum-cron
%endif
%{_sbindir}/yum-cron
%{_mandir}/man*/yum-cron.*

%if %{yum_updatesd}
%files updatesd
%defattr(-, root, root)
%config(noreplace) %{_sysconfdir}/yum/yum-updatesd.conf
%config %{_sysconfdir}/rc.d/init.d/yum-updatesd
%config %{_sysconfdir}/dbus-1/system.d/yum-updatesd.conf
%{_datadir}/yum-cli/yumupd.py*
%{_sbindir}/yum-updatesd
%{_mandir}/man*/yum-updatesd*
%endif

%changelog
* Tue Aug 06 2019 CentOS Sources <bugs@centos.org> - 3.4.3-163.el7.centos
- CentOS yum config
-  use the CentOS bug tracker url
-  retain installonly limit of 5
-  ensure distrover is always from centos-release
- Make yum require yum-plugin-fastestmirror

* Wed May 17 2019 Michal Domonkos <mdomonko@redhat.com> - 3.4.3-163
- Fix from_repo yumdb validator for local pkgs
- Resolves: bug#1510491

* Wed Mar 27 2019 Michal Domonkos <mdomonko@redhat.com> - 3.4.3-162
- downloadonly: unlink .tmp files on ctrl-c
- Resolves: bug#1410234
- Fix calculation of uncleaned disk space after "yum clean all"
- Resolves: bug#1645173
- Speed up depsolving in Anaconda for large transactions
- Resolves: bug#1600383

* Wed Aug 15 2018 Michal Domonkos <mdomonko@redhat.com> - 3.4.3-161
- Improve retry logic for gpg keys
- Resolves: bug#1520454

* Mon Jul 16 2018 Michal Domonkos <mdomonko@redhat.com> - 3.4.3-160
- Only print full disk usage in verbose mode on "yum clean all"
- Resolves: bug#1481220

* Fri Jun 22 2018 Michal Domonkos <mdomonko@redhat.com> - 3.4.3-159
- Retry on gpgkey timeout from MirrorManager
- Resolves: bug#1520454
- docs: baseurl: clarify multiple URLs
- Resolves: bug#1509831
- updateinfo: preload pkgSack
- Resolves: bug#1528608
- update(): honor multilib_policy for obsoletes
- Resolves: bug#1477574
- Print a disk usage summary on "yum clean all" and clarify docs
- Resolves: bug#1481220
- depsolve: filter out conflicting provider
- Resolves: bug#1480065
- Change 'size' option to 'maxsize' in yum.logrotate
- Resolves: bug#1506890

* Sun Nov 26 2017 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-158
- Add support for yum-shell exit status.
- Resolves: bug#1278333

* Fri Nov 03 2017 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-157
- docs: clarify variable name matching.
- Resolves: bug#1411692

* Wed Nov 01 2017 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-156
- Preload shared libs that we may dlopen().
- Resolves: bug#1458841
- Update payload_gpgcheck documentation.
- Resolves: bug#1451817
- Make exactarchlist support wildcards and add docs.
- Resolves: bug#1361609
- Add usercache config option.
- Resolves: bug#1432319

* Thu Oct 06 2017 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-155
- Don't pollute stderr in FIPS mode.
- Resolves: bug#1287610
- Don't require enabled repos for URL installs.
- Resolves: bug#1175315
- installonlypkgs: add "installonlypkg(kernel)
- Resolves: bug#1358492
- Manpage fixes.
- Resolves: bug#1386597
- Resolves: bug#1411575

* Mon Mar 27 2017 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-154
- Add payload_gpgcheck option.
- Resolves: bug#1343690
- Add hint about rm -rf for yum clean all.
- Resolves: bug#1357083
- Have "yum check" ignore self conflicts.
- Resolves: bug#1370134
- Detect installed virtual provide in install().
- Resolves: bug#1352585
- Fix reget problems with simple md filenames.
- Resolves: bug#1397829

* Thu Mar 02 2017 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-153
- Filter duplicates when counting security updates.
- Resolves: bug#1399628
- sqlitesack: fix filelist queries for duplicate pkgs.
- Resolves: bug#1391507

* Mon Feb 06 2017 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-152
- Fix 'history package-list'.
- Resolves: bug#1410326

* Thu Feb 02 2017 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-151
- Add repo-id to repomd timestamp error message.
- Resolves: bug#1389816
- Don't recommend makecache if just running.
- Resolves: bug#1369389
- Add logging of bad update notice duplicates.
- Resolves: bug#1194915

* Mon Sep 19 2016 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-150
- Check for _metadata_cache_req properly.
- Resolves: bug#1377328

* Mon Aug 29 2016 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-149
- Report __del__ RepoError exceptions into log instead of stderr.
- Resolves: bug#1356797

* Thu Aug 04 2016 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-148
- Don't change method signature for lazy:packages.
- Related: bug#1337105

* Fri Jul 22 2016 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-147
- Better exception handling in fssnap.
- Resolves: bug#1335250

* Thu Jul 21 2016 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-146
- Fix count of applicable security updates.
- Related: bug#1292160
- Update the docs for compare_providers_priority.
- Related: bug#1186690

* Mon Jul 18 2016 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-145
- yum-cron: properly replace 'localhost' with system_name value in email_from.
- Related: bug#1330670

* Fri Jul 01 2016 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-144
- Fixed the required python-urlgrabber version.
- Related: bug#1337105

* Thu Jun 30 2016 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-143
- Add lazy:packages caching option.
- Resolves: bug#1337105
- Install comps.rng on the system.
- Resolves: bug#1348995
- Typo fixes.
- Resolves: bug#1339168
- yum-cron: replace 'localhost' with system_name value in email_from.
- Resolves: bug#1330670

* Thu May 19 2016 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-142
- Reworked the respin suffix patch.
- Related: bug#1065380

* Thu May 19 2016 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-141
- updateinfo: strip respin suffix if present.
- Resolves: bug#1065380
- Mention subscription-manager for enabling repos.
- Resolves: bug#1175309

* Wed May 11 2016 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-140
- Fix bash-completion dir in Makefile.
- Related: bug#1293513

* Tue May 10 2016 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-139
- Add autosavets option allowing to avoid autosaving transactions.
- Resolves: bug#1208803
- Add compare_providers_priority repository option.
- Resolves: bug#1186690
- skipbroken: don't installonly_limit if new pkg fails.
- Resolves: bug#1330423
- Recommend --disablerepo and subscription-manager when a repo fails.
- Resolves: bug#1195745
- Fix a typo in exclude_updates().
- Resolves: bug#1327962
- Fix 'updateinfo list all' traceback and indicate if the package is installed.
- Resolves: bug#1328023
- Explicitly list the bash completions directory.
- Resolves: bug#1293513

* Fri Apr 29 2016 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-138
- Read FS yumvars before yum.conf setup, and reread if installroot changed.
- Resolves: bug#1281593
- Cope with older installonly packages from deps.
- Resolves: bug#1306142
- Add metadata_expire_filter to repoinfo output.
- Resolves: bug#1321651
- yum-cron: don't crash with non-ascii email.
- Resolves: bug#1202680
- Fix fssnapshot section in the manpage.
- Resolves: bug#1168121
- yum-cron: don't fail on empty transaction.
- Resolves: bug#1004853
- Fix summary for yum fs command.
- Resolves: bug#1309676
- yum-cron: fix the parsing of update_cmd.
- Resolves: bug#1294789
- Make YumHistoryRpmdbProblem objects hashable.
- Resolves: bug#1292087
- Allow for validating attributes read from yumdb.
- Resolves: bug#1234967

* Tue Apr 05 2016 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-137
- Honor proxy=_none_ set in yum.conf.
- Resolves: bug#1293670
- Fix the default value for query_install_excludes config option.
- Resolves: bug#1291745
- Add ftp_disable_epsv config option.
- Resolves: bug#1293378
- Add ppc64le and aarch64 to rpmUtils.arch.arches.
- Resolves: bug#1272058
- Clarify using 'group list' command for hidden groups in the man page.
- Resolves: bug#1279483

* Tue Mar 22 2016 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-136
- Fix updateinfo to exclude wrong arch updates.
- Resolves: bug#1292160
- Exclude duplicates from the list of security updates.
- Resolves: bug#1267897
- Fix 'updateinfo list available' logic and make 'updates' the default.
- Resolves: bug#1292150

* Mon Mar 21 2016 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-135
- Search new providers for realpath filenames.
- Resolves: bug#1235623

* Thu Mar 17 2016 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-134
- Disable repo with skip_if_unavailable=True if repomd.xml can't be retrieved.
- Resolves: bug#1183669

* Wed Mar 16 2016 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-133
- Fail on attempting to install a non-existent group.
- Resolves: bug#1267234
- Add config options skip_missing_names_on_install and skip_missing_names_on_update.
- Resolves: bug#1274211

* Wed Sep 09 2015 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-132
- Don't fail on empty lines in group files.
- Resolves: bug#1259837

* Wed Aug 12 2015 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-131
- Update not enough space messages for fssnapshot.
- Related: bug#1047793

* Thu Jul 30 2015 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-130
- Fix fssnap_automatic_devices and fssnap_automatic_percentage in yum.conf manpage.
- Resolves: bug#1244119

* Mon Jul 13 2015 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-129
- Fix UnboundLocalError in deselect().
- Related: bug#1168385
- Update the URL of kcs article.
- Related: bug#1200338

* Thu Jul 09 2015 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-128
- Stop caching fssnapshot postfixes and add microseconds.
- Related: bug#1047793

* Wed Jul 01 2015 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-127
- Fix lvm API calls. Patch by Marek Marusic.
- Resolves: bug#1233152

* Thu May 21 2015 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-126
- Fix update-minimal traceback and ignoring updates.
- Resolves: bug#1192239
- Expect KB as well as MB in disk requirements message from rpm.
- Resolves: bug#1212514
- Make sure epoch is a string while checking for running kernel.
- Resolves: bug#1212506
- Fix tsInfo.conditionals in deselect() when the package is not yet in the transaction.
- Resolves: bug#1168385
- Replace 'upgrade-minimal' with documented 'update-minimal' in yum-cron.conf files.
- Resolves: bug#1182096
- Add query_install_excludes conf./docs and use it for list/info/search/provides.
- Resolves: bug#1212519
- Don't traceback on xml parsing.
- Resolves: bug#1063177
- Fix casing of 'yum grouplist' headers.
- Resolves: bug#1211384
- Show advisory even if package arch changed.
- Resolves: bug#1193871
- Add fssnap_abort_on_errors config option and improve detecting if lvm is installed.
- Resolves: bug#1047793
- Fix default for fssnap_automatic_keep in the man page and dad logging for automatic fssnap events.
- Resolves: bug#1145485
- yum manpage: move 'history info' description to its proper place.
- Resolves: bug#1168120
- Add missing documentation from yum-security manpage.
- Resolves: bug#1182075
- Add links to knowledge base articles for http errors 404 and 403 and curl error 60.
- Resolves: bug#1199976
- Resolves: bug#1200312
- Resolves: bug#1200338
- API v2.7: missing_requires, pretty_output_update, promptYN fix, confList.
- Resolves: bug#1188960

* Mon Jan 12 2015 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-125
- Roll back the broken lvm patch.
- Related: bug#1047793

* Thu Nov 13 2014 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-124
- normpath() file URIs.
- Resolves: bug#1095146

* Mon Nov 10 2014 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-123
- Fix debuginfo-install doLock() traceback.
- Resolves: bug#1147992

* Mon Sep 29 2014 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-122
- Don't look for upgrades for install only packages.
- Resolves: bug#1063181

* Wed Sep 24 2014 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-121
- Fix variable substitution.
- Resolves: bug#1102585
- Fix history searching for [abc] character lists failures.
- Resolves: bug#1096147
- Fix update-minimal command in the man page.
- Resolves: bug#1087911

* Thu Sep  4 2014 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-120
- Fix and refactor utils.get_process_info().
- Resolves: bug#1138205

* Thu Sep  4 2014 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-119
- Don't create lockdir directories.
- Resolves: rhbz#1130939
- Mask st_mode to fix verifying permissions for ghost files.
- Resolves: rhbz#1113395
- Check /usr for writability before running a transaction.
- Resolves: rhbz#1097383
- Make --setopt handle spaces properly.
- Resolves: rhbz#1095161
- Fix traceback when the history dir is empty.
- Resolves: rhbz#1095157
- Test for lvm binary before using.
- Resolves: rhbz#1047793

* Tue Apr 15 2014 James Antill <james.antill@redhat.com> - 3.4.3-118
- Remove CHUNK argument from open() for weird anaconda C NULL exception.
- Resolves: rhbz#1058297

* Tue Apr  8 2014 James Antill <james.antill@redhat.com> - 3.4.3-117
- Remove del for weird anaconda C NULL exception.
- Resolves: rhbz#1058297

* Tue Mar 25 2014 James Antill <james.antill@redhat.com> - 3.4.3-116
- Fix traceback on removing doc dirs.
- Resolves: rhbz#1062959
- Tweak docs for groups info, showing yum remove results.
- Resolves: rhbz#833087

* Tue Mar 11 2014 James Antill <james.antill@redhat.com> - 3.4.3-115
- Change docs for groups to make group_command=objects clearer.
- Resolves: rhbz#833087

* Sun Feb 23 2014 James Antill <james.antill@redhat.com> - 3.4.3-114
- Fix /etc/yum.conf saving in fs filter.
- Resolves: rhbz#1062959

* Fri Feb 21 2014 James Antill <james.antill@redhat.com> - 3.4.3-113
- Add fs sub-command and container creation fixes/optimizations.
- Resolves: rhbz#1062959

* Thu Jan 23 2014 Zdenek Pavlas <zpavlas@redhat.com> - 3.4.3-112
- Improve yum-cron messages and error handling.
- Resolves: rhbz#1040619
- Enable yum_cron_systemd
- Resolves: rhbz#1040620
- Update "yum check" description.
- Resolves: rhbz#1015000

* Mon Jan 20 2014 James Antill <james.antill@redhat.com> - 3.4.3-111
- A few simple perf, UI, bug, and docs. fixes.
- Resolves: rhbz#1053289
- A few group related bug fixes from pre-f20 testing.
- Resolves: rhbz#1052436

* Wed Jan 15 2014 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-110
- yum-cron: fail when sigCheckPkg() returns 2
- Resolves: bug#1052994
- depsolve_loop_limit=<forever> should try forever

* Fri Jan 10 2014 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-109
- Fix quotes in the manpage
- Resolves: bug#1050902

* Wed Jan 8 2014 Valentina Mukhamedzhanova <vmukhame@redhat.com> - 3.4.3-108
- Replace optparse._ with ugettext
- Related: bug#1033416

* Fri Dec 27 2013 Daniel Mach <dmach@redhat.com> - 3.4.3-107
- Mass rebuild 2013-12-27

* Thu Nov 21 2013 Zdenek Pavlas <zpavlas@redhat.com> - 3.4.3-106.2
- _getsysver(): compat behavior when both pkg name and provide match.
- Related: bug#1002977

* Wed Nov 20 2013 Zdenek Pavlas <zpavlas@redhat.com> - 3.4.3-106.1
- _getsysver(): use the version of the provide.
- Related: bug#1002977

* Tue Nov  5 2013 Zdenek Pavlas <zpavlas@redhat.com> - 3.4.3-106
- More reliable po.localpath file:// URL test. BZ 1004089
- Disable drpms for local repositories. BZ 1007097
- docs: fix formatting of "yum swap" examples. BZ 1009154
- docs: update "yum check" extra args description. BZ 1014993
- Implement pkg.remote_url for YumLocalPackage. BZ 1016148
- Give same non-exist msg. for install @foo as group install foo. BZ 1018833.
- UpdateNotice.xml(): sanitize pkg['epoch']. BZ 1020540
- yum-cron: support download/install with update_messages==False. BZ 1018068
- Fix some bugs in setopt for repo config. entries. BZ 1023595.
- Add loop limit for depsolving. BZ 1017840.
- Small change how distroverpkg config. works. BZ 1002977.
- _readRawRepoFile: return only valid (ini, section_id). BZ 1018795

* Fri Oct 25 2013 James Antill <james.antill@redhat.com> - 3.4.3-105
- Always call group commands when in non-groups as objects mode.
- Resolves: bug#1002439

* Fri Oct 25 2013 Zdenek Pavlas <zpavlas@redhat.com> - 3.4.3-104
- Same-mirror retry on refused connections. Helps BZ 853432

* Mon Sep  9 2013 James Antill <james.antill@redhat.com> - 3.4.3-103
- Add cache check to repolist, using "!". Document repoinfo.
- Add epoch to updateinfo xml output.
- Add missing translation hooks for ignored -c option message.
- Try to smooth out the edge cases for cacheReq not ever updating data.
- update /etc/yum-cron-hourly.conf. BZ 1002623
- Tweak y-c-t and history redo msg. BZ 974576.
- docs: $arch does not map 1:1 to uname(2) arch. BZ 1003554
- checkMD: re-check when xattr matches but size==0. BZ 1002494
- Use new comps. mock objects to re-integrate group removal. BZ 996866.
- Add "weak" comps. groups, for installed groups.
- Add msg. to help users deal with RepoError failures. BZ 867389.
- Give msgs about install/trans. obsoletes a higher priority. BZ 991080.

* Tue Aug 13 2013 Zdenek Pavlas <zpavlas@redhat.com> - 3.4.3-102
- smtp-compliant email_from default. BZ 982696
- Fix the .reason handling and update/depupdated split. BZ 961938.
- Override users umask for groups files, so users can read it. BZ 982361.
- Also check groups dirname(), for better user messages. BZ 982361.
- Add "--disableincludes" option to yum. BZ 911422
- yum-cron: override the default stdout codec.  BZ 992797
- fix file:// repository && downloadonly. BZ 903294, BZ 993567
- deltarpm: _wait(block=True) should not wait for all running jobs. BZ 991694
- make mdpolicy=group:small default, add group and pkgtags. BZ 989231
- yum-cron: use the [base] section to override yum.conf. BZ 968529
- Don't unlink .drpm files from file:// repos. BZ 999591
- waitForLock() raises YumBaseError. BZ 1001154
- checkMD: re-check when xattr matches but size==0. BZ 1002494
- Add per-repository "keepcache" option to yum. BZ 1001072

* Tue Jul 30 2013 Zdenek Pavlas <zpavlas at redhat.com> - 3.4.3-101
- Pass arch of package to applydeltarpm. BZ 981314.
- Clean up new files when reverting to old repomd.xml
- Get correct rpmdb path from rpm configuration
- repoMDObject.dump_xml() "distro" tag fix
- Fix parsing of power7+ platform string. BZ 980275
- updatesObsoletesList: add repoid arg. BZ 984297
- findRepos: handle re.compile() errors. BZ 984356
- updatesObsoletesList: add repoid arg. BZ 984297
- Preload from root cache when --cacheonly. BZ 830523, 903631
- Add debuglevel option to yum-cron.conf BZ 873428, 982088
- RepoMD: support loading/dumping of <delta>s.
- yum-cron: use [base] section
- yum-cron: fix the download but don't appy updates case. BZ 983076
- group install/update: handle "No Groups Available" exception. BZ 983010
- misc.decompress(): handle OSError, too. BZ 989948
- yum-distro-configs: update installonly_limit default in yum.conf.5
- Remove "kernel-modules" from installonly list. BZ 801067

* Wed Jun 26 2013 Zdenek Pavlas <zpavlas at redhat.com> - 3.4.3-100
- Move the import statement up. BZ 902357

* Mon Jun 24 2013 James Antill <james at fedoraproject.org> - 3.4.3-99
- Update to latest HEAD.
- Fix igroups not being reset in "ts reset" and anaconda. BZ 924162.
- Check for bad checksum types at runtime. BZ 902357.
- fix --cacheonly edge case. BZ 975619.

* Wed Jun 19 2013 James Antill <james at fedoraproject.org> - 3.4.3-98
- Update to latest HEAD.
- Add simple way to specify a group of pkgs. for version. BZ 913461.
- Change group install => group upgrade for installed groups. BZ 833087.
- Give more text when telling user about y-c-t, mention history. BZ 974576.
- Fix the tolerant yum.conf text.
- Skip installonly limit, if something has set check_future_rpmdbv. BZ 962757.

* Mon Jun 17 2013 James Antill <james at fedoraproject.org> - 3.4.3-97
- Update to latest HEAD.
- Minor updates to fssnapshot command.
- metalink: Don't assume maxconnections is always set. BZ 974826.
- DeltaPackage: provide returnIdSum(). BZ 974394.

* Fri Jun 14 2013 James Antill <james at fedoraproject.org> - 3.4.3-96
- Update to latest HEAD.
- Add real logging to updateinfo parsing.
- Merge fssnap command.
- Extend repos.findRepos() API so it can handle repolist input.
- Add a prelistenabledrepos plugin point.
- Auto. enable disabled repos. in repo-pkgs.
- Do cacheRequirement() tests before doCheck().

* Fri Jun 14 2013 Zdenek Pavlas <zpavlas@redhat.com> - 3.4.3-95
- DeltaPackage compat fix. BZ 974394

* Wed Jun 12 2013 Zdenek Pavlas <zpavlas@redhat.com> - 3.4.3-94
- Update to latest HEAD.
- downloadonly: prefetch also pkg checksums. BZ 973380
- Fix superfluous dots after "via" in man pages. BZ 972764
- support "proxy = libproxy" syntax to enable libproxy. BZ 857263
- checkEnabledRepo: run prereposetup if necessary. BZ 826096

* Mon Jun  3 2013 James Antill <james at fedoraproject.org> - 3.4.3-93
- update to latest HEAD.
- Workaround anaconda passing None as group name. BZ 959710.
- Fix second part of igrp as grp problems. BZ 955236.
- Add a fuzzy matcher for numbers in format_missing_requires. BZ 718245.
- Hide the "downloadonly" option when nothing to download.
- Add the "minrate" option. BZ 964298

* Tue May 21 2013 James Antill <james at fedoraproject.org> - 3.4.3-92
- update to latest HEAD.
- returnPackagesByDep() API fix (really old break).
- Try to make groups conversion better.
- progress.start: supply the default filename & url.  BZ 963023
- drpm retry: add RPM sizes to total size.  BZ 959786
- YumBaseError: safe str(e).  BZ 963698

* Mon May 13 2013 Zdenek Pavlas <zpavlas@redhat.com> - 3.4.3-91
- same-mirror retry also on timeout.  BZ 853432

* Wed May  8 2013 James Antill <james at fedoraproject.org> - 3.4.3-90
- Massive hack for Fedora/updateinfo stable vs. testing statuses. BZ 960642.
- Don't load updateinfo when we don't have to.
- Tell which repo. we are skipping the updateinfo notice from.
- Compat. code so we can treat groups/igroups the same. BZ 955236.
- Don't highlight the empty space, Eg. --showdups list.

* Thu May  2 2013 Bill Nottingham <notting@redhat.com> - 3.4.3-89
- Fix defaults-for-environment optional groups change. BZ 958531

* Tue Apr 30 2013 James Antill <james at fedoraproject.org> - 3.4.3-88
- update to latest HEAD.
- Allow default on Environment optional groups.
- Tweak load-ts output.

* Fri Apr 26 2013 James Antill <james at fedoraproject.org> - 3.4.3-87
- update to latest HEAD.
- Make --downloadonly skip userconfirm prompt.
- Turn metadata_expire off for yum-cron.
- Skip var_arch storage in yumdb.

* Tue Apr 23 2013 James Antill <james at fedoraproject.org> - 3.4.3-86
- update to latest HEAD.
- A fix for environments and not installed groups. BZ 928859.
- Add downloadonly option to download prompt.

* Fri Apr 19 2013 James Antill <james at fedoraproject.org> - 3.4.3-85
- update to latest HEAD.
- A couple of fixes for yum-cron using security.
- Add documentation for updateinfo merge.

* Thu Apr 18 2013 James Antill <james at fedoraproject.org> - 3.4.3-84
- update to latest HEAD.
- Move yum-security into core.
- A bunch of minor fixes for yum-cron.
- Update yum-cron to add security/minimal/etc. updates.
- Add socks support to proxy config.

* Tue Apr 16 2013 Zdenek Pavlas <zpavlas@redhat.com> - 3.4.3-83
- update to latest HEAD.
- Update yum-cron to make it worthwhile on Fedora.
- Fix the installed/depinstalled split.  BZ 952162
- rebuilding deltarpms: fix the callback==None case. BZ 952357
- Reuse mirrors when max_retries > len(mirrors).  BZ 765598

* Thu Apr  4 2013 James Antill <james at fedoraproject.org> - 3.4.3-82
- update to latest HEAD.
- Keep installedFileRequires in sync. BZ 920758.
- Add repo-pkgs upgrade-to.
- Document autoremove commands.

* Thu Mar 28 2013 James Antill <james at fedoraproject.org> - 3.4.3-81
- update to latest HEAD.
- Fix optional packages getting installed by default. BZ 923547.
- cacheReq() added to groups command.
- Finally fix the installed obsoletes problem.
- Sync specfiles.
- Turn checking on, and fix check-po script.

* Wed Mar 27 2013 Zdenek Pavlas <zpavlas@redhat.com> - 3.4.3-80
- package also %{compdir}'s parent
- set correct dir when bytecompiling /usr/share/yum-cli
- add fast package name completion (disabled by default)

* Wed Mar 20 2013 Zdenek Pavlas <zpavlas@redhat.com> - 3.4.3-79
- add BuildRequires: bash-completion

* Wed Mar 20 2013 Zdenek Pavlas <zpavlas@redhat.com> - 3.4.3-78
- update to latest HEAD.
- add bash-completion aliases, use pkg-config.
- spelling fixes

* Tue Mar 19 2013 Zdenek Pavlas <zpavlas@redhat.com> - 3.4.3-77
- move bash-completion scripts to /usr/share/  BZ 922992

* Tue Mar 12 2013 James Antill <james at fedoraproject.org> - 3.4.3-76
- Change groups_command default to objects.
- update to latest HEAD.
- Add timestamp to transaction object for plugins etc.

* Mon Mar 11 2013 James Antill <james at fedoraproject.org> - 3.4.3-75
- update to latest HEAD.
- Fix deltarpm=0.
- Fix double unlink. BZ 919657.

* Fri Mar  8 2013 James Antill <james at fedoraproject.org> - 3.4.3-74
- update to latest HEAD.
- Fix obsoletes in "yum check".
- Drop drpm rebuild defaults back to 2 workers.

* Thu Mar  7 2013 James Antill <james at fedoraproject.org> - 3.4.3-73
- update to latest HEAD.
- Queue for drpm rebuilding.
- Sort drpms.

* Wed Mar  6 2013 James Antill <james at fedoraproject.org> - 3.4.3-72
- update to latest HEAD.
- Translation updates.
- Smarter selection of drpm candidates.
- "makecache fast".
- Minor updates.

* Fri Mar  1 2013 James Antill <james at fedoraproject.org> - 3.4.3-70
- update to latest HEAD.
- Reimport the size calculation fix.

* Thu Feb 28 2013 James Antill <james at fedoraproject.org> - 3.4.3-69
- drpm: Fix getDiscNum() sorting bug. BZ 916675.
- Move to just dumping upstream HEAD again.

* Thu Feb 28 2013 Zdeněk Pavlas <zpavlas@redhat.com> - 3.4.3-67
- drpm: fixed the yum._up==None case.
- drpm: repo_gen_decompress() to handle all comp types.

* Wed Feb 27 2013 Zdeněk Pavlas <zpavlas@redhat.com> - 3.4.3-66
- fixed getDiscNum bug
- fixed rpmsize calculation
- obsoleted yum-presto plugin

* Tue Feb 26 2013 Zdeněk Pavlas <zpavlas@redhat.com> - 3.4.3-65
- start downloading drpms before rpms
- deactivate presto if deltarpm package is not installed
- rename "presto" option to "deltarpm".
- new DeltaPO class instead of in-place rpm=>drpm patching.

* Fri Feb 22 2013 Zdeněk Pavlas <zpavlas@redhat.com> - 3.4.3-64
- use multiple applydeltarpm workers (4 by default)

* Thu Feb 21 2013 Zdeněk Pavlas <zpavlas@redhat.com> - 3.4.3-63
- Added native drpm support.

* Tue Feb 19 2013 James Antill <james at fedoraproject.org> - 3.4.3-62
- update to latest HEAD.
- Add cache-reqs.
- Fixup specfile for Fedora <= 18 usage.

* Mon Feb 18 2013 James Antill <james at fedoraproject.org> - 3.4.3-60
- update to latest HEAD.
- Auto expire caches on repo errors.
- Use xattrs for cache checksum speedup.

* Fri Feb 15 2013 James Antill <james at fedoraproject.org> - 3.4.3-59
- update to latest HEAD.
- Add load-ts helper.
- Update downloadonly plugin version obs.

* Fri Feb  8 2013 James Antill <james at fedoraproject.org> - 3.4.3-58
- update to latest HEAD.
- Add pyxattr require for origin_urls for everyone.
- Fix yum-cron service file and scriptlets.
- Fix instant broken mirrors problem.

* Thu Jan 31 2013 James Antill <james at fedoraproject.org> - 3.4.3-57
- update to latest HEAD.
- Fix autoremove foo.
- Speedup/fix repo-pkgs <foo> update with obsoletes.

* Wed Jan 30 2013 James Antill <james at fedoraproject.org> - 3.4.3-56
- update to latest HEAD.
- Add yumvar dumping into yumdb.
- Add ui_repoid_vars configuration.
- Update translations.

* Tue Jan 22 2013 James Antill <james at fedoraproject.org> - 3.4.3-55
- update to latest HEAD.
- Add repo-pkgs update/list and tweak remove-or-sync.

* Mon Jan 21 2013 James Antill <james at fedoraproject.org> - 3.4.3-54
- update to latest HEAD.
- Add repo-pkgs docs. add erase/etc. aliases.
- Fix for 895854.

* Wed Jan 16 2013 James Antill <james at fedoraproject.org> - 3.4.3-53
- update to latest HEAD.
- Add repo-pkgs.
- Add swap.
- Add remove_leaf_only and repopkgremove_leaf_only.
- Add metadata_expire_filter.

* Tue Jan 15 2013 Zdeněk Pavlas <zpavlas@redhat.com> - 3.4.3-52
- update to latest HEAD
- _lock(): yet another exception2msg fix.  BZ 895060
- use yum-cron.service.  BZ 893593
- YumRepo.populate(): always decompresses new database

* Wed Jan  9 2013 Zdeněk Pavlas <zpavlas@redhat.com> - 3.4.3-51
- update to latest HEAD
- Include langpacks when reading and writing comps. BZ 879030
- selectGroup(): Fix a typo. BZ 885139
- move the basename checking into _repos.doSetup(). BZ 885159
- bash completion: offer nvra for multi-install packages
- fixes extra '</pkglist>' tags on multi-collection errata. BZ 887407
- Include the update date in updateinfo xml. BZ 887935
- Complete provides/whatprovides with filenames. BZ 891561
- New locking code.  BZ 865601

* Thu Dec 06 2012 Zdeněk Pavlas <zpavlas@redhat.com> - 3.4.3-50
- update to latest HEAD.
- Check for possible inf. recursion and workaround in skip-broken. BZ 874065
- Don't error in history list, when we have no history. BZ 802462
- Avoid converting to unicode and back in dump_xml_*.  BZ 716235
- po.xml_dump_{primary,filelists,other}_metadata() cleanup

* Wed Nov 28 2012 Zdenek Pavlas  <zpavlas@redhat.com> - 3.4.3-49
- update to latest HEAD.
- Fix ugly paths in po.xml_dump_*(). BZ 835565.
- Fix yum-cron requires.

* Mon Nov 19 2012 Zdenek Pavlas  <zpavlas@redhat.com> - 3.4.3-48
- update to latest HEAD.
- add skip-broken option to yum-cron.
- get rid of bogus "Downloaded package .. but it was invalid."
- clean up misc.to_xml(), make it faster.  BZ 716235.
- checksum not available implies checksum does not match.  BZ 825272.
- avoid checksumming existing .sqlite.bz2 files.
- fix circular obsoletes in transaction members check. BZ 868840.

* Thu Oct 25 2012 Zdenek Pavlas  <zpavlas@redhat.com> - 3.4.3-47
- replaced yum-cron.sh with the new yum-cron.py (very alpha)

* Thu Oct 25 2012 Nils Philippsen <nils@redhat.com> - 3.4.3-46
- bump release to ensure upgrade path and satisfy PackageKit deps

* Wed Oct 17 2012 James Antill <james at fedoraproject.org> - 3.4.3-44
- update to latest HEAD.
- Add downloadonly into core, and enable background downloads.
- Lots of minor fixes.

* Fri Sep  7 2012 James Antill <james at fedoraproject.org> - 3.4.3-43
- update to latest HEAD.
- Use .ui_id explicitly for backcompat. on strings, *sigh*.

* Sat Sep  1 2012 James Antill <james at fedoraproject.org> - 3.4.3-42
- update to latest HEAD.
- Fix missing self. on last patch.

* Fri Aug 31 2012 James Antill <james at fedoraproject.org> - 3.4.3-41
- update to latest HEAD.
- Don't statvfs when we aren't going to copy, and using relative.

* Thu Aug 30 2012 James Antill <james at fedoraproject.org> - 3.4.3-40
- update to latest HEAD.
- Fix rel-eng problems when repo.repofile is None.
- Don't statvfs when we aren't going to copy.

* Tue Aug 28 2012 James Antill <james at fedoraproject.org> - 3.4.3-36
- update to latest HEAD.
- Fix environment groups write.
- Allow merging of updateinfo.
- Add releasever/arch to repoids on output, if used in urls.
- Merge mirror errors fix.

* Thu Aug 23 2012 Zdenek Pavlas <zpavlas at redhat.com> - 3.4.3-34
- Some users skip setupProgressCallbacks(). BZ 850913.

* Wed Aug 22 2012 Zdenek Pavlas <zpavlas at redhat.com> - 3.4.3-33
- update to latest HEAD.
- Set multi_progress_obj option
- Show full URLs and mirror errors when _getFile() fails.

* Thu Aug 16 2012 James Antill <james at fedoraproject.org> - 3.4.3-32
- update to latest HEAD.
- Some fixes for new environment groups.
- Fix "yum upgrade" download verification. BZ 848811.

* Fri Aug 10 2012 James Antill <james at fedoraproject.org> - 3.4.3-31
- update to latest HEAD.
- Big update, mostly for "environment groups".

* Sun Jul 22 2012 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 3.4.3-30
- Rebuilt for https://fedoraproject.org/wiki/Fedora_18_Mass_Rebuild

* Wed Jun 20 2012 Zdenek Pavlas <zpavlas at redhat.com> - 3.4.3-29
- update to latest HEAD.
- quote uids to keep cachedir ascii-clean.  BZ 832195
- show_lock_owner: report errors if we fail.  BZ 745281

* Thu Jun 14 2012 Zdenek Pavlas <zpavlas at redhat.com> - 3.4.3-28
- update to latest HEAD.
- No async downloading when --cacheonly.  BZ 830523
- misc.decompress(): compare mtime without sub second precision. BZ 831918
- preload_from_sys to user dir with --cacheonly, BZ 830523

* Fri Jun  8 2012 James Antill <james at fedoraproject.org> - 3.4.3-27
- update to latest HEAD.
- Fix for ppc64p7 detection.

* Wed May 16 2012 Zdenek Pavlas <zpavlas at redhat.com> - 3.4.3-26
- update to latest master HEAD
- Fix using available packages as installed, due to strong_requires.
- Remove tracebacks on MD downloads. BZ 822009.

* Mon May 14 2012 Zdenek Pavlas <zpavlas at redhat.com> - 3.4.3-25
- update to latest HEAD.
- merged multi-downloader code
- rebased yum-ppc64-preferred.patch
- dropped arm-arch-detection.patch (moved to HEAD)
- renamed yum-update.cron to 0yum-update.cron

* Fri Apr 27 2012 James Antill <james at fedoraproject.org> - 3.4.3-24
- Add code for arm detection.

* Fri Mar 16 2012 James Antill <james at fedoraproject.org> - 3.4.3-23
- update to latest HEAD.
- Also fix "yum check" for strong requires. bug 795907.
- Fix for "Only update available" on downgrade. bug 803346.

* Fri Mar  9 2012 James Antill <james at fedoraproject.org> - 3.4.3-22
- update to latest HEAD.
- Fail on bad reinstall/downgrade arguments. bug 800285.
- Fix weird multiple obsoletion bug. BZ 800016
- Check for a compat. arch. as well, when hand testing for upgradability.
- Allow changing the exit code on non-fatal errors.

* Thu Mar  1 2012 James Antill <james at fedoraproject.org> - 3.4.3-21
- update to latest HEAD.
- Translation update.

* Wed Feb 29 2012 James Antill <james at fedoraproject.org> - 3.4.3-20
- update to latest HEAD.
- Lazy setup pkgSack, for localinstall/etc.
- add support for 64 bit arm hardware.
- Hack for "info install blah" to never look at repos.
- Fixup resolvedep command for mock users.

* Mon Feb 20 2012 James Antill <james at fedoraproject.org> - 3.4.3-19
- update to latest HEAD.
- Add a yum group convert command, so people can use groups as objects easily.
- Document the new group stuff.
- Generic provide markers for installonlypkgs (for kernel/vms).
- Minor updates/fixes merge some older branches.

* Fri Jan 20 2012 James Antill <james at fedoraproject.org> - 3.4.3-18
- update to latest HEAD
- Added group_command, but didn't change to groups as objects by default.
- Minor updates.

* Sat Jan 14 2012 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 3.4.3-17
- Rebuilt for https://fedoraproject.org/wiki/Fedora_17_Mass_Rebuild

* Tue Dec 13 2011 James Antill <james at fedoraproject.org> - 3.4.3-16
- update to latest HEAD
- Have users always use their own dirs.
- Minor updates.

* Fri Dec  2 2011 James Antill <james at fedoraproject.org> - 3.4.3-15
- update to latest HEAD
- Init "found" variable for distro-sync full. BZ 752407.
- Fix _conv_pkg_state when calling with history as checksum. BZ 757736.
- When a repo. fails in repolist, manually populate the ones after it.A
- Fix a corner case in exception2msg(). BZ 749239.
- Transifex sync.
- Hand fix the plural forms gettext stuff.

* Wed Nov 30 2011 Dennis Gilmore <dennis@ausil.us> - 3.4.3-13
- add patch from upstream for arm hardware floating point support

* Mon Oct 17 2011 James Antill <james at fedoraproject.org> - 3.4.3-12
- update to latest HEAD
- Basically just an update for transifex sync.

* Fri Oct 14 2011 James Antill <james at fedoraproject.org> - 3.4.3-11
- update to latest HEAD
- Some edge case depsolver bug fixes.
- Output the GPG fingerprint when showing the GPG key.
- Update bugtracker URL back to redhat.
- Allow reinstall and remove arguments to history redo command.
- Let resolvedep look for installed packages.

* Wed Sep 21 2011 James Antill <james at fedoraproject.org> - 3.4.3-10
- update to latest HEAD
- Fix for history sync, and saving on install.
- Lots of minor bug fixes.
- Speedups for upgrade_requirements_on_install=true.
- Fix generated data using bad caches.
- Changes for yum-cron.

* Tue Aug 23 2011 James Antill <james at fedoraproject.org> - 3.4.3-9
- update to latest HEAD
- Update translations.
- Minor UI tweaks for transaction output.
- Minor tweak for update_reqs_on_install.

* Mon Aug 22 2011 James Antill <james at fedoraproject.org> - 3.4.3-8
- update to latest HEAD
- Fix upgrade_requirements_on_install breaking upgrade typos.

* Fri Aug 19 2011 James Antill <james at fedoraproject.org> - 3.4.3-7
- update to latest HEAD
- Fix syncing of yum DB data in history.
- Add upgrade_requirements_on_install config. option.
- Don't look for releasever if it's set directly (anaconda).
- Expose ip_resolve urlgrabber option.

* Fri Aug  5 2011 James Antill <james at fedoraproject.org> - 3.4.3-6
- update to latest HEAD
- Add new yum DB data.
- Add hack to workaround broken python readline in yum shell.
- Make "yum -q history addon-info last saved_tx" valid input for load-ts.
- Add "history packages-info/stats/sync" sub-commnands.

* Fri Jul 29 2011 James Antill <james at fedoraproject.org> - 3.4.3-5
- update to latest HEAD
- Lots of really minor changes. Docs. and yum-cron mainly.
- Output yum_saved_tx file.

* Fri Jul 15 2011 James Antill <james at fedoraproject.org> - 3.4.3-4
- update to latest HEAD
- Weird old bugs fixed for new createrepo code.
- Add --assumeno and an easter egg! Also allow remove to use alwaysprompt.
- Fix \r appearing on serial console etc. BZ 720088.
- Fix umask on mkdir() as well as open. BZ 719467.
- Fix traceback when enabling/disabling repos. in GUI.

* Thu Jun 30 2011 James Antill <james at fedoraproject.org> - 3.4.3-3
- Fix the skip broken tuples => dict. bug. BZ 717973.

* Wed Jun 29 2011 James Antill <james at fedoraproject.org> - 3.4.3-2
- Add ppc64 arch. change for BZ 713791.

* Tue Jun 28 2011 James Antill <james at fedoraproject.org> - 3.4.3-1
- update to 3.4.3
- Real upstream workaround for rpm chroot and history insanity.
- Minor bugfixes.

* Wed Jun 22 2011 James Antill <james at fedoraproject.org> - 3.4.2-2
- Workaround rpm chroot insanity.

* Wed Jun 22 2011 James Antill <james at fedoraproject.org> - 3.4.2-1
- update to 3.4.2
- Lots of smallish bug fixes/tweaks.
- Lookup erase transaction members, by their name, if we can.
- Added pluralized translation messages.

* Tue Jun 14 2011 James Antill <james at fedoraproject.org> - 3.4.1-5
- update to latest HEAD
- Lots of smallish bug fixes.
- New groups command.

* Thu Jun  2 2011 James Antill <james at fedoraproject.org> - 3.4.1-4
- update to latest HEAD
- Fix RepoStorage problem for pulp.
- Add list of not found packages.
- Minor bug fixes.

* Tue May 24 2011 James Antill <james at fedoraproject.org> - 3.4.1-3
- update to latest HEAD
- Tweak "yum provides"
- Don't access the repos. for saved_tx, if doing a removal.
- Fix a couple of old minor bugs:
- Remove usage of INFO_* from yumcommands, as -q supresses that. BZ 689241.
- Don't show depsolve failure messages for non-depsolving problems. BZ 597336.

* Wed May  4 2011 James Antill <james at fedoraproject.org> - 3.4.1-2
- update to latest HEAD
- Fix consolidate_libc.
- Update translations.
- Add history rollback.

* Wed Apr 20 2011 James Antill <james at fedoraproject.org> - 3.4.1-1
- Fix umask override.
- Remove double baseurl display, BZ 697885.

* Fri Apr 15 2011 James Antill <james at fedoraproject.org> - 3.4.0-1
- update to 3.4.0.

* Fri Apr  8 2011 James Antill <james at fedoraproject.org> - 3.2.29-10
- update to latest HEAD 
- Likely last HEAD before 3.2.30.

* Fri Mar 25 2011 Seth Vidal <skvidal at fedoraproject.org> - 3.2.29-9
- update to latest HEAD 

* Mon Feb 28 2011 Seth Vidal <skvidal at fedoraproject.org> - 3.2.29-8
- take out the hack-patch from 2 weeks ago.

* Mon Feb 28 2011 Seth Vidal <skvidal at fedoraproject.org> - 3.2.29-7
- latest head including all of Panu's rpmutils/callback patches

* Thu Feb 17 2011 Seth Vidal <skvidal at fedoraproject.org> - 3.2.29-6
- add rpmutils-recursive-import.patch to work around recursive import problems

* Wed Feb 16 2011 Seth Vidal <skvidal at fedoraproject.org> - 3.2.29-5
- lots of hopefully NOT exciting changes to rpmutils/rpmsack from head.

* Tue Feb 08 2011 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 3.2.29-4
- Rebuilt for https://fedoraproject.org/wiki/Fedora_15_Mass_Rebuild

* Tue Jan 25 2011 Seth Vidal <skvidal at fedoraproject.org> - 3.2.29-3
- latest from head - fixing a number of minor bugs

* Thu Jan 13 2011 Seth Vidal <skvidal at fedoraproject.org> - 3.2.29-2
- grumble broken skip-broken test :(


* Thu Jan 13 2011 Seth Vidal <skvidal at fedoraproject.org> - 3.2.29-1
- 3.2.29
- add yum-cron subpkg

* Thu Jan  6 2011 James Antill <james at fedoraproject.org> - 3.2.28-17
- Allow kernel installs with multilib protection ... oops!
- Don't conflict with fixed versions of Zif.
- Add locks for non-root.

* Tue Jan  4 2011 Seth Vidal <skvidal at fedoraproject.org> - 3.2.28-16
- fix skip-broken conflict - thanks dgilmore for the catch

* Tue Jan  4 2011 Seth Vidal <skvidal at fedoraproject.org> - 3.2.28-15
- latest head
- conflicts zif

* Thu Nov 11 2010 James Antill <james at fedoraproject.org> - 3.2.28-14
- latest head
- Perf. fixes/improvements.

* Tue Nov  9 2010 Seth Vidal <skvidal at fedoraproject.org> - 3.2.28-13
- once again with head

* Fri Nov  5 2010 James Antill <james at fedoraproject.org> - 3.2.28-12
- latest head
- Add load-ts command.
- Fix verifying symlinks.

* Wed Oct 20 2010 Seth Vidal <skvidal at fedoraproject.org> - 3.2.28-11
- latest head
- depsolve enhancements on update/obsoletes
- show recent pkgs in history package-list instead of a specific pkg
- bz: 644432, 644265
- make sure urlgrabber is using the right config settings for fetching gpg keys


* Fri Oct 15 2010 James Antill <james at fedoraproject.org> - 3.2.28-10
- latest head 
- Fix major breakage from the "list updates" speedup :).
- Close curl/urlgrabber after downloading packages.
- Allow remove+update in "yum shell".
- Fix output of distro tags.

* Thu Oct  7 2010 James Antill <james at fedoraproject.org> - 3.2.28-9
- latest head 
- Add localpkg_gpgcheck option.
- Speedup "list updates"
- Doc fixes.

* Sat Sep 25 2010 James Antill <james at fedoraproject.org> - 3.2.28-8
- latest head 
- Speedup install/remove/etc a lot.
- Add merged history.
- Fix unique comps/pkgtags leftovers.

* Tue Sep 14 2010 James Antill <james at fedoraproject.org> - 3.2.28-7
- latest head 
- Fix PK/auto-close GPG import bug.
- Fix patch for installonly_limit and enable it again.
- Fix rpmlint warnings.
- Remove color=never config.

* Fri Sep 10 2010 Seth Vidal <skvidal at fedoraproject.org>
- latest head 

* Fri Aug 27 2010 Seth Vidal <skvidal at fedoraproject.org>
- obsoleted yum-plugin-download-order

* Thu Aug 12 2010 Seth Vidal <skvidal at fedoraproject.org> - 3.2.28-3
- latest head
- fix gpg key import
- more unicode fixes
- output slightly more clear depsovling error msgs

* Mon Aug  9 2010 Seth Vidal <skvidal at fedoraproject.org> - 3.2.28-2
- latest head
- unicide fixes
- sqlite history db conversion fixes


* Fri Jul 30 2010 Seth Vidal <skvidal at fedoraproject.org> - 3.2.28-1
- 3.2.28


* Wed Jul 28 2010 Mamoru Tasaka <mtasaka@ioa.s.u-tokyo.ac.jp> - 3.2.27-21
- Again rebuild against python 2.7

* Mon Jul 26 2010 Seth Vidal <skvidal at fedoraproject.org> - 3.2.27-20
- latest head
- minor fixes and doc updates
- hardlink yumdb files to conserve spacde
- cache yumdb results

* Thu Jul 22 2010 David Malcolm <dmalcolm@redhat.com> - 3.2.27-19
- Rebuilt for https://fedoraproject.org/wiki/Features/Python_2.7/MassRebuild

* Fri Jul 16 2010 James Antill <james@fedoraproject.org> - 3.2.27-18
- Latest head.
- Add history addon-info.
- Add new callbacks, verify and compare_providers.
- Fix rpm transaction fail API break, probably only for anaconda.
- Bug fixes.

* Fri Jun 25 2010 James Antill <james@fedoraproject.org> - 3.2.27-17
- Latest head.
- Allow reinstalls of kernel, etc.
- Tweaks to some user output.
- Allow Fedora GPG keys to be removed.
- Add history extra data API, and history plugin hooks.
- Bunch of minor bug fixes.

* Tue Jun 15 2010 James Antill <james@fedoraproject.org> - 3.2.27-16
- Latest head.
- Fix install being recorded as reinstall.
- Make localinstall not install obsoleted only by installed.
- Fix info -v, on available packages.
- Fix man page stuff.
- Deal with unicide on rpmdb problems.
- Allow ipkg.repo.name to work.
- Add ville's epoch None vs. 0 code, in compareEVR.

* Fri Jun 11 2010 James Antill <james@fedoraproject.org> - 3.2.27-15
- Latest head.
- Add filtering requires code for createrepo.
- Add installed_by/changed_by yumdb values.
- Tweak output for install/reinstall/downgrade callbacks.
- Add plugin hooks for pre/post verifytrans.
- Deal with local pkgs. which only obsolete.
- No chain removals on downgrade.
- Bunch of speedups for "list installed blah", and "remove blah".

* Wed Jun  2 2010 Seth Vidal <skvidal at fedoraproject.org> - 3.2.27-14
- merge in latest yum head:
- change decompressors to support lzma, if python module is available
- finnish translation fixes
- pyint vs pylong fix for formatRequire() so we stop spitting back the wrong requires strings to mock on newish rpm
- add exit_on_lock option
- Deal with RHEL-5 loginuid damage
- Fix pkgs. that are excluded after being put in yb.up ... BZ#597853
- Opt. for rpmdb.returnPackages(patterns=...). Drops about 30%% from remove time.
- Fix "remove name-version", really minor API bug before last patch

* Wed May 26 2010 Seth Vidal <skvidal at fedoraproject.org> - 3.2.27-13
- minor cleanups for yum-utils with --setopt
- translation updates

* Thu May 13 2010 James Antill <james@fedoraproject.org> - 3.2.27-12
- Latest head.
- History db version 2
- Some bug fixes
- More paranoid/leanient with rpmdb cache problems.

* Wed May  5 2010 James Antill <james@fedoraproject.org> - 3.2.27-11
- Fix from head for mock, mtime=>ctime due to caches and fixed installroot
- Fix for typo in new problems code, bug 589008

* Mon May  3 2010 Seth Vidal <skvidal at fedoraproject.org> - 3.2.27-10
- latest head
- fixes yum chroot path duplication
- yum.log perms

* Thu Apr 29 2010 James Antill <james@fedoraproject.org> - 3.2.27-9
- Latest yum-3_2_X head.
- Added protect packages.
- Bug fixes from the yum bug day.
- Added removed size output.
- Added glob: to all list config. options.
- Fix fsvars.

* Thu Apr 22 2010 James Antill <james@fedoraproject.org> - 3.2.27-8
- Latest yum-3_2_X head.
- Add deselections.
- Add simple depsolve into compare_providers
- Speedup distro-sync blah.

* Fri Apr 16 2010 James Antill <james@fedoraproject.org> - 3.2.27-7
- Latest yum-3_2_X head.
- Add the "big update" speedup patch.
- Add nocontexts ts flag.
- Add provides and obsoleted to "yum check".
- Add new dump_xml stuff for createrepo/modifyrepo.
- Move /var/lib/yum/vars to /etc/yum/vars

* Mon Apr 12 2010 James Antill <james@fedoraproject.org> - 3.2.27-6
- Latest yum-3_2_X head.
- Fix the caching changes.

* Sat Apr 10 2010 James Antill <james@fedoraproject.org> - 3.2.27-5
- Latest yum-3_2_X head.
- Remove the broken assert in sqlitesack

* Thu Apr  8 2010 Seth Vidal <skvidal at fedoraproject.org> - 3.2.27-4
- more latest headness

* Fri Mar 26 2010 James Antill <james@fedoraproject.org> - 3.2.27-3
- Latest yum-3_2_X head.

* Tue Mar 23 2010 Seth Vidal <skvidal at fedoraproject.org> - 3.2.27-2
- broke searching in PK, this patch fixes it.

* Thu Mar 18 2010 Seth Vidal <skvidal at fedoraproject.org> - 3.2.27-1
- 3.2.27 from upstream (more or less the same as 3.2.26-6 but with a new number

* Thu Mar 11 2010 Seth Vidal <skvidal at fedoraproject.org> - 3.2.26-6
- should be the final HEAD update before 3.2.27

* Wed Feb 24 2010 James Antill <james@fedoraproject.org> - 3.2.26-5
- new HEAD, minor features and speed.

* Wed Feb 17 2010 Seth Vidal <skvidal at fedoraproject.org> - 3.2.26-4
- new HEAD to fix the fix to the fix

* Tue Feb 16 2010 Seth Vidal <skvidal at fedoraproject.org> - 3.2.26-3
- latest head - including fixes to searchPrcos

* Wed Feb 10 2010 Seth Vidal <skvidal at fedoraproject.org> - 3.2.26-2
- grumble.

* Tue Feb  9 2010 Seth Vidal <skvidal at fedoraproject.org> - 3.2.26-1
- final 3.2.26

* Mon Feb  8 2010 Seth Vidal <skvidal at fedoraproject.org> - 3.2.25-14
- $uuid, pkgtags searching, latest HEAD patch - pre 3.2.26

* Thu Jan 28 2010 James Antill <james at fedoraproject.org> - 3.2.25-13
- A couple of bugfixes, most notably:
-  you can now install gpg keys again!
-  bad installed file requires don't get cached.

* Fri Jan 22 2010 Seth Vidal <skvidal at fedoraproject.org> - 3.2.25-12
- someone forgot to push their changes

* Fri Jan 22 2010 Seth Vidal <skvidal at fedoraproject.org> - 3.2.25-11
- more fixes, more fun

* Fri Jan 15 2010 James Antill <james at fedoraproject.org> - 3.2.25-10
- latest head
- Fixes for pungi, rpmdb caching and kernel-PAE-devel duplicates finding
- among others.

* Mon Jan  4 2010 Seth Vidal <skvidal at fedoraproject.org> - 3.2.25-8
- latest head
