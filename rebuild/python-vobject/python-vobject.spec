%global modname vobject
%global sum A python library for manipulating vCard and vCalendar files


Name:           python-vobject
Version:        0.9.6.1
Release:        5%{?dist}
Summary:        %{sum}

License:        ASL 2.0
URL:            http://eventable.github.io/vobject/
Source0:        https://pypi.python.org/packages/source/v/vobject/%{modname}-%{version}.tar.gz

BuildArch:      noarch
BuildRequires:  git


%description
VObject is intended to be a full featured python library for parsing and
generating vCard and vCalendar files.


%package -n         python3-%{modname}
Summary:            %{sum}

Requires:           python3-dateutil
Requires:           python3-setuptools
BuildRequires:      python3-devel
BuildRequires:      python3-setuptools
BuildRequires:      python3-dateutil

%{?python_provide:%python_provide python3-%{modname}}

%description -n python3-vobject
VObject is intended to be a full featured python library for parsing and
generating vCard and vCalendar files.


%prep
%autosetup -n %{modname}-%{version} -p1
sed -i -e 's| == 2.4.0||' setup.py
rm vobject/win32tz.py

%build
%py3_build


%install
%py3_install


%check

# Currently failing
%{__python3} setup.py test


%files -n python3-%{modname}
%doc README.md
# ACKNOWLEDGEMENTS.txt
#%license LICENSE-2.0.txt
%{python3_sitelib}/%{modname}/
%{python3_sitelib}/%{modname}-%{version}-*
%{_bindir}/change_tz
%{_bindir}/ics_diff


%changelog
* Thu Aug 22 2019 Miro Hrončok <mhroncok@redhat.com> - 0.9.6.1-5
- Subpackage python2-vobject has been removed
  See https://fedoraproject.org/wiki/Changes/Mass_Python_2_Package_Removal

* Mon Aug 19 2019 Miro Hrončok <mhroncok@redhat.com> - 0.9.6.1-4
- Rebuilt for Python 3.8

* Fri Jul 26 2019 Fedora Release Engineering <releng@fedoraproject.org> - 0.9.6.1-3
- Rebuilt for https://fedoraproject.org/wiki/Fedora_31_Mass_Rebuild

* Sat Feb 02 2019 Fedora Release Engineering <releng@fedoraproject.org> - 0.9.6.1-2
- Rebuilt for https://fedoraproject.org/wiki/Fedora_30_Mass_Rebuild

* Tue Jul 24 2018 Pierre-Yves Chibon <pingou@pingoured.fr> - 0.9.6-1
- Update to 0.9.6

* Sat Jul 14 2018 Fedora Release Engineering <releng@fedoraproject.org> - 0.9.5-4
- Rebuilt for https://fedoraproject.org/wiki/Fedora_29_Mass_Rebuild

* Tue Jul 03 2018 Dan Horák <dan[at]danny.cz> - 0.9.5-3
- fix tests for Python 3.7 (#1597678)

* Tue Jun 19 2018 Miro Hrončok <mhroncok@redhat.com> - 0.9.5-2
- Rebuilt for Python 3.7

* Fri Feb 23 2018 Pierre-Yves Chibon <pingou@pingoured.fr> - 0.9.5-1
- Update to 0.9.5

* Fri Feb 09 2018 Fedora Release Engineering <releng@fedoraproject.org> - 0.9.4.1-5
- Rebuilt for https://fedoraproject.org/wiki/Fedora_28_Mass_Rebuild

* Wed Jan 31 2018 Iryna Shcherbina <ishcherb@redhat.com> - 0.9.4.1-4
- Update Python 2 dependency declarations to new packaging standards
  (See https://fedoraproject.org/wiki/FinalizingFedoraSwitchtoPython3)

* Thu Jul 27 2017 Fedora Release Engineering <releng@fedoraproject.org> - 0.9.4.1-3
- Rebuilt for https://fedoraproject.org/wiki/Fedora_27_Mass_Rebuild

* Sat Feb 11 2017 Fedora Release Engineering <releng@fedoraproject.org> - 0.9.4.1-2
- Rebuilt for https://fedoraproject.org/wiki/Fedora_26_Mass_Rebuild

* Thu Jan 26 2017 Pierre-Yves Chibon <pingou@pingoured.fr> - 0.9.4.1-1
- Update to 0.9.4.1

* Mon Dec 26 2016 Pierre-Yves Chibon <pingou@pingoured.fr> - 0.9.3-1
- Update to 0.9.3

* Mon Dec 19 2016 Miro Hrončok <mhroncok@redhat.com> - 0.9.2-4
- Rebuild for Python 3.6

* Tue Jul 19 2016 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 0.9.2-3
- https://fedoraproject.org/wiki/Changes/Automatic_Provides_for_Python_RPM_Packages

* Thu Apr 21 2016 Toshio Kuratomi <toshio@fedoraproject.org> - 0.9.2-2
- Move the programs to the python3 subpackage so that we don't drag in python3
  with the python2 subpackage.

* Mon Mar 14 2016 Pierre-Yves Chibon <pingou@pingoured.fr> - 0.9.2-1
- Update to 0.9.2

* Tue Feb 16 2016 Pierre-Yves Chibon <pingou@pingoured.fr> - 0.9.0-3
- Remove the file ``vobject/win32tz.py`` not needed for Linux
- Re-enable the unit-tests

* Mon Feb 15 2016 Pierre-Yves Chibon <pingou@pingoured.fr> - 0.9.0-2
- Bring upstream patch fixing vobject with a recent version of dateutil

* Tue Feb 09 2016 Pierre-Yves Chibon <pingou@pingoured.fr> - 0.9.0-1
- Update the spec to the latest guidelines, generating two sub-packages one
  for py2 and one for py3

* Thu Feb 04 2016 Fedora Release Engineering <releng@fedoraproject.org> - 0.8.1c-13
- Rebuilt for https://fedoraproject.org/wiki/Fedora_24_Mass_Rebuild

* Thu Jun 18 2015 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 0.8.1c-12
- Rebuilt for https://fedoraproject.org/wiki/Fedora_23_Mass_Rebuild

* Mon Feb 23 2015 Pierre-Yves Chibon <pingou@pingoured.fr> - 0.8.1c-11
- Add patch 0001-Require-dateutil-1.5.patch enforcing the version of
  python-dateutils used

* Sun Jun 08 2014 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 0.8.1c-10
- Rebuilt for https://fedoraproject.org/wiki/Fedora_21_Mass_Rebuild

* Sun Aug 04 2013 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 0.8.1c-9
- Rebuilt for https://fedoraproject.org/wiki/Fedora_20_Mass_Rebuild

* Thu Feb 14 2013 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 0.8.1c-8
- Rebuilt for https://fedoraproject.org/wiki/Fedora_19_Mass_Rebuild

* Sat Jul 21 2012 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 0.8.1c-7
- Rebuilt for https://fedoraproject.org/wiki/Fedora_18_Mass_Rebuild

* Sat Jan 14 2012 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 0.8.1c-6
- Rebuilt for https://fedoraproject.org/wiki/Fedora_17_Mass_Rebuild

* Wed Nov 02 2011 Pierre-Yves Chibon <pingou@pingoured.fr> - 0.8.1c-5
- Add python-setuptools as requires since it is needed for the ics_diff script

* Wed Feb 09 2011 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 0.8.1c-4
- Rebuilt for https://fedoraproject.org/wiki/Fedora_15_Mass_Rebuild

* Thu Jul 22 2010 David Malcolm <dmalcolm@redhat.com> - 0.8.1c-3
- Rebuilt for https://fedoraproject.org/wiki/Features/Python_2.7/MassRebuild

* Sun Jul 26 2009 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 0.8.1c-2
- Rebuilt for https://fedoraproject.org/wiki/Fedora_12_Mass_Rebuild

* Fri Apr 03 2009 James Bowes <jbowes@redhat.com> - 0.8.1c-1
- Update to 0.8.1c

* Thu Feb 26 2009 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 0.8.1b-2
- Rebuilt for https://fedoraproject.org/wiki/Fedora_11_Mass_Rebuild

* Sun Feb 08 2009 James Bowes <jbowes@redhat.com> - 0.8.1b-1
- Update to 0.8.1b

* Mon Jan 05 2009 James Bowes <jbowes@redhat.com> - 0.8.0-1
- Update to 0.8.0

* Sat Nov 29 2008 Ignacio Vazquez-Abrams <ivazqueznet+rpm@gmail.com> - 0.7.1-3
- Rebuild for Python 2.6

* Wed Sep 03 2008 James Bowes <jbowes@redhat.com> - 0.7.1-2
- Add change_tz executable

* Wed Sep 03 2008 James Bowes <jbowes@redhat.com> - 0.7.1-1
- Update to 0.7.1

* Thu Jul 24 2008 James Bowes <jbowes@redhat.com> - 0.7.0-1
- Update to 0.7.0

* Wed Jun 11 2008 James Bowes <jbowes@redhat.com> - 0.6.6-1
- Update to 0.6.6

* Fri May 30 2008 James Bowes <jbowes@redhat.com> - 0.6.5-1
- Update to 0.6.5

* Thu Mar 13 2008 James Bowes <jbowes@redhat.com> - 0.6.0-2
- Remove use of ez_setup; we already have setuptools.

* Thu Mar 13 2008 James Bowes <jbowes@redhat.com> - 0.6.0-1
- Update to 0.6.0

* Thu Jan 17 2008 James Bowes <jbowes@redhat.com> - 0.5.0-1
- Update to 0.5.0

* Wed Dec 12 2007 James Bowes <jbowes@redhat.com> - 0.4.9-2
- Use new egg-info guidlines for F9

* Sun Dec 02 2007 James Bowes <jbowes@redhat.com> - 0.4.9-1
- Update to 0.4.9

* Thu Aug 23 2007 James Bowes <jbowes@redhat.com> - 0.4.8-1
- Update to 0.4.8

* Sat Dec 09 2006 James Bowes <jbowes@redhat.com> - 0.4.4-2
- Add BR: python-devel

* Sun Nov 26 2006 James Bowes <jbowes@redhat.com> - 0.4.4-1
- New version released.

* Sat Oct 07 2006 James Bowes <jbowes@redhat.com> - 0.4.3-1
- New version released.

* Sun Sep 10 2006 James Bowes <jbowes@redhat.com> 0.4.1-2
- Stop ghosting pyo files.

* Sat Aug 12 2006 James Bowes <jbowes@redhat.com> 0.4.1-1
- New version released.
- Handle egg info.

* Thu Jun 29 2006 James Bowes <jbowes@redhat.com> 0.3.0-1
- Initial packaging.
