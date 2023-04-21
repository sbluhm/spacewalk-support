# Not building for EPEL 6 or 7 at present due to issues building
# python-httpbin; see that package's spec for details

# Disable Python 2 builds for Fedora > 29, EPEL > 7
%if 0%{?fedora} > 29 || 0%{?rhel} > 7
%bcond_with         python2
%global obsolete2   1
%else
%bcond_without      python2
%global obsolete2   0
%endif

%global github_owner    kevin1024
%global github_name     pytest-httpbin
%global modname         pytest_httpbin

%global desc Pytest-httpbin creates a pytest fixture that is dependency-injected into your \
tests. It automatically starts up a HTTP server in a separate thread running \
a local instance of httpbin (a web service for testing HTTP libraries) and \
provides your test with the URL in the fixture.

%global sum Fixture providing local instance of httpbin test service

%global t_requires python2-httpbin python2-six python2-pytest
%global t3_requires python3-httpbin python3-six python3-pytest

Name:           python-%{github_name}
Version:        0.3.0
Release:        11%{?dist}
Summary:        %{sum}

# License is included in-line in README.md
License:        MIT
URL:            https://github.com/%{github_owner}/%{github_name}
# NOTE: the source includes a CA trust bundle (certs/cacert.pem). We
# don't replace it with the system-wide trust bundle because it's only
# used for httpbin itself and contains only the self-signed cert,
# valid only for 127.0.0.1, that the test server uses. We can't
# replace it because we can't actually securely have the test server
# use a cert that would be trusted by the system-wide trust bundle.
Source0:        https://github.com/%{github_owner}/%{github_name}/archive/v%{version}.tar.gz

# Make the tests work with pytest >= 3.6
Patch1:         https://github.com/kevin1024/pytest-httpbin/pull/50.patch

BuildArch:      noarch

%description
%{desc}

#################################################################################
%if %{with python2}
%package -n python2-%{github_name}
Summary:        %{sum}

BuildRequires:  python2-setuptools
BuildRequires:  python2-devel
# For tests
BuildRequires:  python2-requests
BuildRequires:  %{t_requires}

%{?python_provide:%python_provide python2-%{github_name}}
Requires:       %{t_requires}

%description -n python2-%{github_name}
%{desc}

This package provides the Python 2 implementation.
%endif # with python2

%package -n python3-%{github_name}
Summary:        %{sum}

BuildRequires:  python3-setuptools
BuildRequires:  python3-devel
# For tests
BuildRequires:  python3-requests
BuildRequires:  %{t3_requires}

%{?python_provide:%python_provide python3-%{github_name}}
Requires:       %{t3_requires}
%if 0%{?obsolete2}
Obsoletes:      python2-%{github_name} < %{version}-%{release}
%endif # obsolete2

%description -n python3-%{github_name}
%{desc}

This package provides the Python 3 implementation.

#################################################################################
%prep
%autosetup -n %{github_name}-%{version} -p1


%build
%if %{with python2}
%py2_build
%endif # with python2
%py3_build

%install
%if %{with python2}
%py2_install
%endif # with python2
%py3_install

#################################################################################
%check
%if %{with python2}
PYTHONPATH=./ py.test-2
%endif # with python2
#PYTHONPATH=./ py.test-3

#################################################################################
%if %{with python2}
%files -n python2-%{github_name}
%{python2_sitelib}/%{modname}*
%doc DESCRIPTION.rst README.md
%endif # with python2

%files -n python3-%{github_name}
%{python3_sitelib}/%{modname}*
%doc DESCRIPTION.rst README.md

#################################################################################
%changelog
* Thu Jan 30 2020 Fedora Release Engineering <releng@fedoraproject.org> - 0.3.0-11
- Rebuilt for https://fedoraproject.org/wiki/Fedora_32_Mass_Rebuild

* Thu Oct 03 2019 Miro Hrončok <mhroncok@redhat.com> - 0.3.0-10
- Rebuilt for Python 3.8.0rc1 (#1748018)

* Sat Aug 17 2019 Miro Hrončok <mhroncok@redhat.com> - 0.3.0-9
- Rebuilt for Python 3.8

* Fri Jul 26 2019 Fedora Release Engineering <releng@fedoraproject.org> - 0.3.0-8
- Rebuilt for https://fedoraproject.org/wiki/Fedora_31_Mass_Rebuild

* Sat Feb 02 2019 Fedora Release Engineering <releng@fedoraproject.org> - 0.3.0-7
- Rebuilt for https://fedoraproject.org/wiki/Fedora_30_Mass_Rebuild

* Fri Nov 23 2018 Adam Williamson <awilliam@redhat.com> - 0.3.0-6
- Disable Python 2 build on F30+
- Drop all EPEL compat bits for now as we can't build on EPEL

* Sat Jul 14 2018 Fedora Release Engineering <releng@fedoraproject.org> - 0.3.0-5
- Rebuilt for https://fedoraproject.org/wiki/Fedora_29_Mass_Rebuild

* Mon Jun 18 2018 Miro Hrončok <mhroncok@redhat.com> - 0.3.0-4
- Make sure not to autouse fixtures from the API

* Mon Jun 18 2018 Miro Hrončok <mhroncok@redhat.com> - 0.3.0-3
- Rebuilt for Python 3.7

* Fri Feb 09 2018 Fedora Release Engineering <releng@fedoraproject.org> - 0.3.0-2
- Rebuilt for https://fedoraproject.org/wiki/Fedora_28_Mass_Rebuild

* Thu Nov 16 2017 Adam Williamson <awilliam@redhat.com> - 0.3.0-1
- New release 0.3.0

* Thu Jul 27 2017 Fedora Release Engineering <releng@fedoraproject.org> - 0.2.3-7
- Rebuilt for https://fedoraproject.org/wiki/Fedora_27_Mass_Rebuild

* Wed May 31 2017 Igor Gnatenko <ignatenko@redhat.com> - 0.2.3-6
- Remove useless (and broken) requires on python3-pkgversion-macros

* Sat Feb 11 2017 Fedora Release Engineering <releng@fedoraproject.org> - 0.2.3-5
- Rebuilt for https://fedoraproject.org/wiki/Fedora_26_Mass_Rebuild

* Thu Dec 29 2016 Adam Williamson <awilliam@redhat.com> - 0.2.3-4
- Drop some unnecessary requirements

* Thu Dec 29 2016 Adam Williamson <awilliam@redhat.com> - 0.2.3-3
- Ensure we own all packaged dirs

* Thu Dec 29 2016 Adam Williamson <awilliam@redhat.com> - 0.2.3-2
- Fix subpackage names

* Thu Dec 29 2016 Adam Williamson <awilliam@redhat.com> - 0.2.3-1
- Initial package
