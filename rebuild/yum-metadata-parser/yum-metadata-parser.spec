%{!?python_sitelib_platform: %define python_sitelib_platform %(%{__python2} -c "from distutils.sysconfig import get_python_lib; print get_python_lib(1)")}


Summary: A fast metadata parser for yum
Name: yum-metadata-parser
Version: 1.1.4
Release: 22%{?dist}
Source0: http://linux.duke.edu/projects/yum/download/%{name}/%{name}-%{version}.tar.gz
Source1: https://www.gnu.org/licenses/old-licenses/gpl-2.0.txt
Patch0: BZ-612409-handle-2GB-rpms.patch
Patch1: UPSTREAM-py-3-split.patch
Patch2: UPSTREAM-weak-deps.patch
Patch3: UPSTREAM-index-weak-deps.patch
Patch4: UPSTREAM-fix-minor-mem-leak.patch
License: GPLv2
Group: Development/Libraries
URL: http://linux.duke.edu/projects/yum/
Conflicts: yum < 3.2.0
BuildRequires: python2-devel
BuildRequires: glib2-devel
BuildRequires: libxml2-devel
BuildRequires: sqlite-devel
BuildRequires: pkgconfig
Requires: glib2 >= 2.15

%description
Fast metadata parser for yum implemented in C.

%prep
%setup -q
%patch0 -p1
%patch1 -p1
%patch2 -p1
%patch3 -p1
%patch4 -p1

cp %{SOURCE1} .

%build
%{__python2} setup.py build

%install
%{__rm} -rf %{buildroot}
%{__python2} setup.py install -O1 --root=%{buildroot}

%files
%defattr(-,root,root,-)
%{!?_licensedir:%global license %%doc}
%license gpl-2.0.txt
%doc README AUTHORS ChangeLog
%{python_sitelib_platform}/_sqlitecache.so
%{python_sitelib_platform}/sqlitecachec.py
%{python_sitelib_platform}/sqlitecachec.pyc
%{python_sitelib_platform}/sqlitecachec.pyo
%{python_sitelib_platform}/*egg-info

%changelog
* Mon Mar 02 2020 Stefan Bluhm <stefan.bluhm@clacee.eu> - 1.1.4-23
- Update __python to __python2 to allow RHEL8 rebuild

* Wed Feb 14 2018 Iryna Shcherbina <ishcherb@redhat.com> - 1.1.4-22
- Update Python 2 dependency declarations to new packaging standards
  (See https://fedoraproject.org/wiki/FinalizingFedoraSwitchtoPython3)

* Fri Feb 09 2018 Fedora Release Engineering <releng@fedoraproject.org> - 1.1.4-21
- Rebuilt for https://fedoraproject.org/wiki/Fedora_28_Mass_Rebuild

* Thu Aug 03 2017 Fedora Release Engineering <releng@fedoraproject.org> - 1.1.4-20
- Rebuilt for https://fedoraproject.org/wiki/Fedora_27_Binutils_Mass_Rebuild

* Thu Jul 27 2017 Fedora Release Engineering <releng@fedoraproject.org> - 1.1.4-19
- Rebuilt for https://fedoraproject.org/wiki/Fedora_27_Mass_Rebuild

* Sat Feb 11 2017 Fedora Release Engineering <releng@fedoraproject.org> - 1.1.4-18
- Rebuilt for https://fedoraproject.org/wiki/Fedora_26_Mass_Rebuild

* Tue Jul 19 2016 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 1.1.4-17
- https://fedoraproject.org/wiki/Changes/Automatic_Provides_for_Python_RPM_Packages

* Fri Feb 05 2016 Fedora Release Engineering <releng@fedoraproject.org> - 1.1.4-16
- Rebuilt for https://fedoraproject.org/wiki/Fedora_24_Mass_Rebuild

* Fri Jun 19 2015 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 1.1.4-15
- Rebuilt for https://fedoraproject.org/wiki/Fedora_23_Mass_Rebuild

* Mon Aug 18 2014 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 1.1.4-14
- Rebuilt for https://fedoraproject.org/wiki/Fedora_21_22_Mass_Rebuild

* Wed Aug  6 2014 Tom Callaway <spot@fedoraproject.org> - 1.1.4-13
- fix license handling

* Sat Jun 07 2014 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 1.1.4-12
- Rebuilt for https://fedoraproject.org/wiki/Fedora_21_Mass_Rebuild

* Tue Apr  8 2014 James Antill <james at fedoraproject.org> 1.1.4-11
- Add indexes to weak dep. tables.
- Fix minor memory leak.

* Mon Mar 10 2014 James Antill <james at fedoraproject.org> 1.1.4-10
- Add py3 build support.
- Add weak deps.

* Sun Aug 04 2013 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 1.1.4-9
- Rebuilt for https://fedoraproject.org/wiki/Fedora_20_Mass_Rebuild

* Fri Feb 15 2013 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 1.1.4-8
- Rebuilt for https://fedoraproject.org/wiki/Fedora_19_Mass_Rebuild

* Sun Jul 22 2012 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 1.1.4-7
- Rebuilt for https://fedoraproject.org/wiki/Fedora_18_Mass_Rebuild

* Sat Jan 14 2012 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 1.1.4-6
- Rebuilt for https://fedoraproject.org/wiki/Fedora_17_Mass_Rebuild

* Thu Feb 24 2011 James Antill <james at fedoraproject.org> 1.1.4-5
- Really handle rpms that are over 2GB, in the .xml to .sqlite conversion.
- Resolves: bz#612409

* Tue Feb 08 2011 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 1.1.4-4
- Rebuilt for https://fedoraproject.org/wiki/Fedora_15_Mass_Rebuild

* Fri Sep 10 2010 James Antill <james at fedoraproject.org> 1.1.4-3
- Handle rpms that are over 2GB, in the .xml to .sqlite conversion.
- Resolves: bz#612409

* Thu Jul 22 2010 David Malcolm <dmalcolm@redhat.com> - 1.1.4-2
- Rebuilt for https://fedoraproject.org/wiki/Features/Python_2.7/MassRebuild

* Thu Jan  7 2010 Seth Vidal <skvidal at fedoraproject.org> - 1.1.4-1
- update to upstream 1.1.4 - which is really just all of these patches rolled into a release

* Tue Aug 18 2009 Seth Vidal <skvidal at fedoraproject.org> - 1.1.2-14
- apply latest patches from upstream - consolidate into one big patch
- test before a 1.1.3 from upstream

* Mon Jul 27 2009 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 1.1.2-13
- Rebuilt for https://fedoraproject.org/wiki/Fedora_12_Mass_Rebuild

* Wed Feb 25 2009 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 1.1.2-12
- Rebuilt for https://fedoraproject.org/wiki/Fedora_11_Mass_Rebuild

* Sat Nov 29 2008 Ignacio Vazquez-Abrams <ivazqueznet+rpm@gmail.com> 1.1.2-11
- Rebuild for Python 2.6

* Tue Oct 14 2008 James Antill <james at fedoraproject.org> 1.1.2-10
- Add delay indexes and no updates patches from upstream.
- Resolves: bug 465898

* Thu Feb 14 2008 Seth Vidal <skvidal at fedoraproject.org> 1.1.2-8
- bump for gcc 

* Fri Jan 25 2008 Seth Vidal <skvidal at fedoraproject.org> 1.1.2-7
- apply exclusive lock patch

* Thu Jan 24 2008 Seth Vidal <skvidal at fedoraproject.org> 1.1.2-6
- add explicit dep on glib2 > 2.15

* Tue Jan 22 2008 Seth Vidal <skvidal at fedoraproject.org> 1.1.2-5
- rebuild

* Tue Jan 08 2008 James Bowes <jbowes@redhat.com> 1.1.2-4
- egg-info is under the arch specific dir

* Tue Jan 08 2008 James Bowes <jbowes@redhat.com> 1.1.2-3
- Include the egg-info dir.

* Tue Nov 27 2007 Paul Nasrat <pauln at truemesh.com> 1.1.2-2
- Fix segmentation fault with no pkgId

* Fri Aug 24 2007 Seth Vidal <skvidal at fedoraproject.org> 1.1.2-1
- 1.1.2-1
- hopefully fixes the mash issues

* Tue Jul 10 2007 James Bowes <jbowes@redhat.com>
- Use the 4 argument form of defattr

* Mon Jul  9 2007 Jeremy Katz <katzj@redhat.com> 
- conflict with yum < 3.2.0 (#247451)

* Tue May 15 2007 Jeremy Katz <katzj@redhat.com> - 1.1.0-2
- export dbversion so that things like createrepo can discover it (#239938)

* Fri Apr 27 2007 Jeremy Katz <katzj@redhat.com> - 1.1.0-1
- update to 1.1.0 for new sqlite db schema

* Wed Apr  4 2007 Jeremy Katz <katzj@redhat.com> - 1.0.4-1
- update to 1.0.4

* Tue Feb 13 2007 James Bowes <jbowes@redhat.com> - 1.0.3-2
- Spec file updates from the merge review: clean the buildroot.

* Mon Jan  8 2007 Jeremy Katz <katzj@redhat.com> - 1.0.3-1
- update to 1.0.3

* Wed Dec  6 2006 Jeremy Katz <katzj@redhat.com> - 1.0-9
- rebuild for python 2.5, support new sqlite

* Wed Sep 27 2006 Jeremy Katz <katzj@redhat.com> - 1.0-8
- fix dep loop

* Wed Jul 12 2006 Jesse Keating <jkeating@redhat.com> 
- rebuild

* Thu Jun 15 2006 Paul Nasrat <pnasrat@redhat.com> - 1.0-7
- add patch to correct population of packages.location_base

* Wed Jun 14 2006 Paul Nasrat <pnasrat@redhat.com> - 1.0-6
- add patch to correct table order of primary:files

* Tue Jun 13 2006 Jeremy Katz <katzj@redhat.com> - 1.0-5
- add patch to be quieter so that we don't break tree composes

* Mon Jun 12 2006 Jeremy Katz <katzj@redhat.com> - 1.0-4
- urls, build into fedora

* Mon Jun 05 2006 Tambet Ingo <tambet@ximian.com> - 1.0-3
- Require yum >= 2.6.2

* Sat Jun 04 2006 Terje Rosten <terje.rosten@pvv.org> - 1.0-2
- add buildrequires
- doc files
- url

* Fri Jun 02 2006 Terje Rosten <terje.rosten@pvv.org> - 1.0-0.1
- initial package

