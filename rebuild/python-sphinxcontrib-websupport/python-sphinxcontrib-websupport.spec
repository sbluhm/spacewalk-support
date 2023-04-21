%if 0%{?fedora} || 0%{?rhel} > 7
%global with_python3 1
%endif

%global commit ebe84efc1a869da8d5689c706cdcf6ea864f0d9b
%global pypi_name sphinxcontrib-websupport

Name:           python-%{pypi_name}
Version:        1.0.1
Release:        12.20180316git%{?dist}
Summary:        Sphinx API for Web Apps

License:        BSD
URL:            http://sphinx-doc.org/
Source0:        https://github.com/sphinx-doc/sphinxcontrib-websupport/archive/%{commit}.tar.gz
BuildArch:      noarch

%description
sphinxcontrib-websupport provides a Python API to easily integrate Sphinx
documentation into your Web application.

%package -n     python2-%{pypi_name}
Summary:        %{summary}
%{?python_provide:%python_provide python2-%{pypi_name}}
BuildRequires:  python2-devel
BuildRequires:  python2-docutils
BuildRequires:  python2-jinja2
BuildRequires:  python2-mock
BuildRequires:  python2-pytest
BuildRequires:  python2-setuptools
BuildRequires:  python2-six
BuildRequires:  python2-sphinx
BuildRequires:  python2-sqlalchemy
BuildRequires:  python2-whoosh
Requires:       python2-docutils
Requires:       python2-jinja2
Requires:       python2-six
Requires:       python2-sphinx
Requires:       python2-sqlalchemy
Requires:       python2-whoosh

%description -n python2-%{pypi_name}
sphinxcontrib-websupport provides a Python API to easily integrate Sphinx
documentation into your Web application.

%if 0%{?with_python3}
%package -n     python3-%{pypi_name}
Summary:        %{summary}
%{?python_provide:%python_provide python3-%{pypi_name}}
BuildRequires:  python3-devel
BuildRequires:  python3-docutils
BuildRequires:  python3-setuptools
BuildRequires:  python3-jinja2
BuildRequires:  python3-mock
BuildRequires:  python3-pytest
BuildRequires:  python3-six
BuildRequires:  python3-sphinx
BuildRequires:  python3-sqlalchemy
BuildRequires:  python3-whoosh
Requires:       python3-docutils
Requires:       python3-jinja2
Requires:       python3-six
Requires:       python3-sphinx
Requires:       python3-sqlalchemy
Requires:       python3-whoosh

%description -n python3-%{pypi_name}
sphinxcontrib-websupport provides a Python API to easily integrate Sphinx
documentation into your Web application.
%endif

%prep
%autosetup -n %{pypi_name}-%{commit}
# Remove bundled egg-info
rm -rf %{pypi_name}.egg-info

%build
%if 0%{?with_python3}
%py3_build
%endif
%py2_build

%install
%if 0%{?with_python3}
%py3_install
%endif
%py2_install

%check
#PYTHONPATH=. py.test tests/
%if 0%{?with_python3}
#PYTHONPATH=. py.test-3 tests/
%endif

%files -n python2-%{pypi_name}
%license LICENSE
%doc README.rst
%{python2_sitelib}/sphinxcontrib/websupport
%{python2_sitelib}/sphinxcontrib_websupport-*.pth
%{python2_sitelib}/sphinxcontrib_websupport-*.egg-info

%if 0%{?with_python3}
%files -n python3-%{pypi_name}
%license LICENSE
%doc README.rst
%{python3_sitelib}/sphinxcontrib/websupport
%{python3_sitelib}/sphinxcontrib_websupport-*.pth
%{python3_sitelib}/sphinxcontrib_websupport-*.egg-info
%endif

%changelog
* Sat Feb 02 2019 Fedora Release Engineering <releng@fedoraproject.org> - 1.0.1-12.20180316git
- Rebuilt for https://fedoraproject.org/wiki/Fedora_30_Mass_Rebuild

* Mon Jul 16 2018 Miro Hrončok <mhroncok@redhat.com> - 1.0.1-11.20180316git
- Remove unused dependency on xapian

* Sat Jul 14 2018 Fedora Release Engineering <releng@fedoraproject.org> - 1.0.1-10.20180316git
- Rebuilt for https://fedoraproject.org/wiki/Fedora_29_Mass_Rebuild

* Fri Jun 15 2018 Miro Hrončok <mhroncok@redhat.com> - 1.0.1-9.20180316git
- Rebuilt for Python 3.7

* Wed May 16 2018 Javier Peña <jpena@redhat.com> - 1.0.1-8.20180316git
- Update to commit ebe84efc1a869da8d5689c706cdcf6ea864f0d9b
- Fix build with Sphinx 1.7 (bz#1578132)

* Wed Feb 28 2018 Iryna Shcherbina <ishcherb@redhat.com> - 1.0.1-7.20171013git
- Update Python 2 dependency declarations to new packaging standards
  (See https://fedoraproject.org/wiki/FinalizingFedoraSwitchtoPython3)

* Fri Feb 09 2018 Fedora Release Engineering <releng@fedoraproject.org> - 1.0.1-6.20171013git
- Rebuilt for https://fedoraproject.org/wiki/Fedora_28_Mass_Rebuild

* Mon Dec 18 2017 Javier Peña <jpena@redhat.com> - 1.0.1-5.20171013git
- Fixed Source0 URL (bz#1526646)

* Fri Oct 13 2017 Javier Peña <jpena@redhat.com> - 1.0.1-4.20171013git
- Updated to latest git commit to fix build in Rawhide

* Wed Oct 11 2017 Troy Dawson <tdawson@redhat.com> - 1.0.1-3
- Cleanup spec file conditionals

* Thu Jul 27 2017 Fedora Release Engineering <releng@fedoraproject.org> - 1.0.1-2
- Rebuilt for https://fedoraproject.org/wiki/Fedora_27_Mass_Rebuild

* Fri Jun 30 2017 Javier Peña <jpena@redhat.com> - 1.0.1-1
- Initial package.

