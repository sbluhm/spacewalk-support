%global pypiname pluggy

%if 0%{?fedora} || 0%{?rhel} > 7
%global with_python3 1
%else
%global with_python3 0
%endif

# Turn the tests off when bootstrapping Python, because pytest requires pluggy
%bcond_without tests

Name:           python-pluggy
Version:        0.6.0
Release:        5%{?dist}
Summary:        The plugin manager stripped of pytest specific details

License:        MIT
URL:            https://github.com/pytest-dev/pluggy
Source0:        https://github.com/pytest-dev/%{pypiname}/archive/%{version}.tar.gz#/%{name}-%{version}.tar.gz


BuildArch:      noarch
BuildRequires:  python2-devel
BuildRequires:  python2-setuptools
%if %{with tests}
BuildRequires:  python2-pytest
%endif

%if 0%{?with_python3}
BuildRequires:  python3-devel
BuildRequires:  python3-setuptools
%if %{with tests}
BuildRequires:  python3-pytest
%endif
%endif # with python3

%global _description\
The plugin manager stripped of pytest specific details.

%description %_description

%package -n python2-%{pypiname}
Summary: %summary
%{?python_provide:%python_provide python2-%{pypiname}}

%description -n python2-%{pypiname} %_description

%if 0%{?with_python3}
%package -n python3-%{pypiname}
Summary:  The plugin manager stripped of pytest specific details.

%description -n python3-%{pypiname}
The plugin manager stripped of pytest specific details.

%endif # with python3


%prep
%autosetup -n %{pypiname}-%{version}


%build
%py2_build

%if 0%{?with_python3}
%py3_build
%endif # with python3


%install
%if 0%{?with_python3}
%py3_install
%endif # with python3

%py2_install

%if %{with tests}
%check
export PYTHONPATH=.:$PYTHONPATH
py.test-2 testing

%if 0%{?with_python3}
py.test-%{python3_version} testing
%endif
%endif # with tests


%files -n python2-%{pypiname}
%doc README.rst
%license LICENSE
%{python2_sitelib}/%{pypiname}
%{python2_sitelib}/%{pypiname}-%{version}-py%{python2_version}.egg-info


%if 0%{?with_python3}
%files -n python3-%{pypiname}
%{python3_sitelib}/%{pypiname}
%{python3_sitelib}/%{pypiname}-%{version}-py%{python3_version}.egg-info
%doc README.rst
%license LICENSE
%endif # with python3


%changelog
* Sat Jul 14 2018 Fedora Release Engineering <releng@fedoraproject.org> - 0.6.0-5
- Rebuilt for https://fedoraproject.org/wiki/Fedora_29_Mass_Rebuild

* Thu Jun 14 2018 Miro Hrončok <mhroncok@redhat.com> - 0.6.0-4
- Rebuilt for Python 3.7

* Thu Jun 14 2018 Miro Hrončok <mhroncok@redhat.com> - 0.6.0-3
- Bootstrap for Python 3.7

* Fri Feb 09 2018 Fedora Release Engineering <releng@fedoraproject.org> - 0.6.0-2
- Rebuilt for https://fedoraproject.org/wiki/Fedora_28_Mass_Rebuild

* Mon Jan 29 2018 Matthias Runge <mrunge@redhat.com> - 0.6.0-1
- update to 0.6.0
- requirement renames to meet python2 names

* Tue Jan 23 2018 Karsten Hopp <karsten@redhat.com> - 0.3.1-10
- fix conditional

* Sat Aug 19 2017 Zbigniew Jędrzejewski-Szmek <zbyszek@in.waw.pl> - 0.3.1-9
- Python 2 binary package renamed to python2-pluggy
  See https://fedoraproject.org/wiki/FinalizingFedoraSwitchtoPython3

* Thu Jul 27 2017 Fedora Release Engineering <releng@fedoraproject.org> - 0.3.1-8
- Rebuilt for https://fedoraproject.org/wiki/Fedora_27_Mass_Rebuild

* Sat Feb 11 2017 Fedora Release Engineering <releng@fedoraproject.org> - 0.3.1-7
- Rebuilt for https://fedoraproject.org/wiki/Fedora_26_Mass_Rebuild

* Mon Dec 19 2016 Miro Hrončok <mhroncok@redhat.com> - 0.3.1-6
- Rebuild for Python 3.6

* Tue Jul 19 2016 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 0.3.1-5
- https://fedoraproject.org/wiki/Changes/Automatic_Provides_for_Python_RPM_Packages

* Thu Feb 04 2016 Fedora Release Engineering <releng@fedoraproject.org> - 0.3.1-4
- Rebuilt for https://fedoraproject.org/wiki/Fedora_24_Mass_Rebuild

* Mon Nov 16 2015 Matthias Runge <mrunge@redhat.com> - 0.3.1-3
- make tests pass again on Python 3.5

* Tue Nov 10 2015 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 0.3.1-2
- Rebuilt for https://fedoraproject.org/wiki/Changes/python3.5

* Mon Sep 21 2015 Matthias Runge <mrunge@redhat.com> - 0.3.1-1
- update to 0.3.1

* Tue Aug 25 2015 Matthias Runge <mrunge@redhat.com> - 0.3.0-3
- fix python3 builds

* Fri Aug 21 2015 Matthias Runge <mrunge@redhat.com> - 0.3.0-2
- add python2_sitelib macros and BR to setuptools (rhbz#1254484)

* Fri Aug 14 2015 Matthias Runge <mrunge@redhat.com> - 0.3.0-1
- version based on the inital proposal of Adam Young
