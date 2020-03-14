%global pypi_name pytest-timeout
%global desc This is a plugin which will terminate tests after a certain timeout. When doing\
so it will show a stack dump of all threads running at the time. This is useful\
when running tests under a continuous integration server or simply if you don’t\
know why the test suite hangs.

Name:           python-%{pypi_name}
Version:        1.3.3
Release:        2%{?dist}
Summary:        py.test plugin to abort hanging tests

License:        MIT
URL:            https://bitbucket.org/pytest-dev/pytest-timeout/
Source0:        https://files.pythonhosted.org/packages/source/p/%{pypi_name}/%{pypi_name}-%{version}.tar.gz
BuildArch:      noarch

BuildRequires:  python2-devel
BuildRequires:  python2-pexpect
BuildRequires:  python2-pytest
BuildRequires:  python3-devel
BuildRequires:  python3-pexpect
BuildRequires:  python3-pytest

%description
%{desc}

%package -n     python2-%{pypi_name}
Summary:        %{summary}
%{?python_provide:%python_provide python2-%{pypi_name}}

Requires:       python2-pytest
%description -n python2-%{pypi_name}
%{desc}

%package -n     python3-%{pypi_name}
Summary:        %{summary}
%{?python_provide:%python_provide python3-%{pypi_name}}

Requires:       python3-pytest
%description -n python3-%{pypi_name}
%{desc}

%prep
%autosetup -n %{pypi_name}-%{version}

%build
%py2_build
%py3_build

%install
%py2_install
%py3_install

%check
PYTHONPATH=%{buildroot}%{python2_sitelib} PYTHONDONTWRITEBYTECODE=1 py.test-%{python2_version}
PYTHONPATH=%{buildroot}%{python3_sitelib} PYTHONDONTWRITEBYTECODE=1 py.test-%{python3_version}


%files -n python2-%{pypi_name}
%doc README
%license LICENSE
%{python2_sitelib}/pytest_timeout*

%files -n python3-%{pypi_name}
%doc README
%license LICENSE
%{python3_sitelib}/pytest_timeout*
%{python3_sitelib}/__pycache__/pytest_timeout*

%changelog
* Sat Feb 02 2019 Fedora Release Engineering <releng@fedoraproject.org> - 1.3.3-2
- Rebuilt for https://fedoraproject.org/wiki/Fedora_30_Mass_Rebuild

* Fri Jan 25 2019 Scott Talbert <swt@techie.net> - 1.3.3-1
- New upstream release 1.3.3

* Tue Oct 23 2018 Scott Talbert <swt@techie.net> - 1.3.2-1
- New upstream release 1.3.2

* Fri Sep 14 2018 Scott Talbert <swt@techie.net> - 1.3.1-2
- Disable writing bytecode when running tests to avoid packaging pycache files

* Tue Jul 24 2018 Scott Talbert <swt@techie.net> - 1.3.1-1
- New upstream release 1.3.1

* Sat Jul 14 2018 Fedora Release Engineering <releng@fedoraproject.org> - 1.3.0-2
- Rebuilt for https://fedoraproject.org/wiki/Fedora_29_Mass_Rebuild

* Wed Jun 27 2018 Scott Talbert <swt@techie.net> - 1.3.0-1
- New upstream release 1.3.0

* Mon Jun 18 2018 Miro Hrončok <mhroncok@redhat.com> - 1.2.1-2
- Rebuilt for Python 3.7

* Wed Jun 13 2018 Scott Talbert <swt@techie.net> - 1.2.1-1
- New upstream release 1.2.1 (fixes FTBFS #1590256)

* Fri Feb 09 2018 Fedora Release Engineering <releng@fedoraproject.org> - 1.2.0-4
- Rebuilt for https://fedoraproject.org/wiki/Fedora_28_Mass_Rebuild

* Fri Jul 28 2017 Scott Talbert <swt@techie.net> - 1.2.0-3
- Updated to use versioned dependency name

* Thu Jul 27 2017 Fedora Release Engineering <releng@fedoraproject.org> - 1.2.0-2
- Rebuilt for https://fedoraproject.org/wiki/Fedora_27_Mass_Rebuild

* Wed May 10 2017 Scott Talbert <swt@techie.net> - 1.2.0-1
- New upstream release 1.2.0
- Enable tests

* Sat Feb 11 2017 Fedora Release Engineering <releng@fedoraproject.org> - 1.0.0-3
- Rebuilt for https://fedoraproject.org/wiki/Fedora_26_Mass_Rebuild

* Tue Dec 13 2016 Stratakis Charalampos <cstratak@redhat.com> - 1.0.0-2
- Rebuild for Python 3.6

* Thu Aug 11 2016 Scott Talbert <swt@techie.net> - 1.0.0-1
- Initial package.
