%global pkgname linecache2

%if 0%{?fedora} || 0%{?rhel} > 7
%bcond_without python3
%else
%bcond_with python3
%endif

# For bootstrapping Python
%bcond_without tests

Name:           python-%{pkgname}
Version:        1.0.0
Release:        19%{?dist}
Summary:        Backport of the linecache module

License:        Python
URL:            https://github.com/testing-cabal/linecache2
Source0:        http://pypi.python.org/packages/source/l/%{pkgname}/%{pkgname}-%{version}.tar.gz

BuildArch:      noarch
BuildRequires:  python2-devel
BuildRequires:  python2-pbr
# Test dependencies
%if %{with tests}
BuildRequires:  python2-fixtures
BuildRequires:  python2-unittest2
%endif # with tests

%if %{with python3}
BuildRequires:  python3-devel
BuildRequires:  python3-pbr
# Test dependencies
%if %{with tests}
BuildRequires:  python3-fixtures
BuildRequires:  python3-unittest2
%endif # with tests
%endif # with python3

%global _description\
A backport of linecache to older supported Pythons.\


%description %_description

%package -n python2-%{pkgname}
Summary: %summary
%{?python_provide:%python_provide python2-%{pkgname}}

%description -n python2-%{pkgname} %_description

%if %{with python3}
%package     -n python3-%{pkgname}
Summary:        Backport of the linecache module

%description -n python3-%{pkgname}
A backport of linecache to older supported Pythons.

%endif # with python3


%prep
%setup -qc
mv %{pkgname}-%{version} python2
# tests/inspect_fodder2.py not Py2 compatible
# besides tests shouldn't be installed
mv python2/%{pkgname}/tests .

%if %{with python3}
cp -a python2 python3
%endif # with python3


%build
pushd python2
%{__python2} setup.py build
popd

%if %{with python3}
pushd python3
%{__python3} setup.py build
popd
%endif # with python3


%install
rm -rf $RPM_BUILD_ROOT
# Must do the python3 install first because the scripts in /usr/bin are
# overwritten with every setup.py install (and we want the python2 version
# to be the default for now).
%if %{with python3}
pushd python3
%{__python3} setup.py install -O1 --skip-build --root $RPM_BUILD_ROOT
popd
%endif # with python3

pushd python2
%{__python2} setup.py install -O1 --skip-build --root $RPM_BUILD_ROOT
popd

%if %{with tests}
%check
pushd python2
mv ../tests %{pkgname}/
%{__python2} -m unittest2 -v
mv %{pkgname}/tests ../
popd

%if %{with python3}
pushd python3
mv ../tests %{pkgname}/
%{__python3} -m unittest2 -v
mv %{pkgname}/tests ../
popd
%endif
%endif # with tests


%files -n python2-%{pkgname}
# license not shipped by upstream
%doc python2/AUTHORS python2/ChangeLog python2/README.rst
%{python2_sitelib}/*

%if %{with python3}
%files -n python3-%{pkgname}
%doc python3/AUTHORS python3/ChangeLog python3/README.rst
%{python3_sitelib}/*
%endif # with python3


%changelog
* Fri Jul 26 2019 Fedora Release Engineering <releng@fedoraproject.org> - 1.0.0-19
- Rebuilt for https://fedoraproject.org/wiki/Fedora_31_Mass_Rebuild

* Sat Feb 02 2019 Fedora Release Engineering <releng@fedoraproject.org> - 1.0.0-18
- Rebuilt for https://fedoraproject.org/wiki/Fedora_30_Mass_Rebuild

* Sat Jul 14 2018 Fedora Release Engineering <releng@fedoraproject.org> - 1.0.0-17
- Rebuilt for https://fedoraproject.org/wiki/Fedora_29_Mass_Rebuild

* Mon Jun 18 2018 Miro Hrončok <mhroncok@redhat.com> - 1.0.0-16
- Rebuilt for Python 3.7

* Wed Jun 13 2018 Miro Hrončok <mhroncok@redhat.com> - 1.0.0-15
- Bootstrap for Python 3.7

* Mon Feb 12 2018 Iryna Shcherbina <ishcherb@redhat.com> - 1.0.0-14
- Update Python 2 dependency declarations to new packaging standards
  (See https://fedoraproject.org/wiki/FinalizingFedoraSwitchtoPython3)

* Fri Feb 09 2018 Fedora Release Engineering <releng@fedoraproject.org> - 1.0.0-13
- Rebuilt for https://fedoraproject.org/wiki/Fedora_28_Mass_Rebuild

* Fri Sep 29 2017 Troy Dawson <tdawson@redhat.com> - 1.0.0-12
- Cleanup spec file conditionals

* Sat Aug 19 2017 Zbigniew Jędrzejewski-Szmek <zbyszek@in.waw.pl> - 1.0.0-11
- Python 2 binary package renamed to python2-linecache2
  See https://fedoraproject.org/wiki/FinalizingFedoraSwitchtoPython3

* Thu Jul 27 2017 Fedora Release Engineering <releng@fedoraproject.org> - 1.0.0-10
- Rebuilt for https://fedoraproject.org/wiki/Fedora_27_Mass_Rebuild

* Sat Feb 11 2017 Fedora Release Engineering <releng@fedoraproject.org> - 1.0.0-9
- Rebuilt for https://fedoraproject.org/wiki/Fedora_26_Mass_Rebuild

* Tue Dec 13 2016 Charalampos Stratakis <cstratak@redhat.com> - 1.0.0-8
- Enable tests

* Fri Dec 09 2016 Charalampos Stratakis <cstratak@redhat.com> - 1.0.0-7
- Rebuild for Python 3.6
- Disable python3 tests

* Tue Jul 19 2016 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 1.0.0-6
- https://fedoraproject.org/wiki/Changes/Automatic_Provides_for_Python_RPM_Packages

* Thu Feb 04 2016 Fedora Release Engineering <releng@fedoraproject.org> - 1.0.0-5
- Rebuilt for https://fedoraproject.org/wiki/Fedora_24_Mass_Rebuild

* Sat Nov 14 2015 Toshio Kuratomi <toshio@fedoraproject.org> - - 1.0.0-4
- And re-enable the tests

* Sat Nov 14 2015 Toshio Kuratomi <toshio@fedoraproject.org> - - 1.0.0-3
- Temproarily disable tests to bootstrap testtools

* Tue Nov 10 2015 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 1.0.0-2
- Rebuilt for https://fedoraproject.org/wiki/Changes/python3.5

* Wed Jul 22 2015 Michel Alexandre Salim <salimma@fedoraproject.org> - 1.0.0-1
- Initial package
