%global dotname backports.functools_lru_cache
%global srcname backports-functools_lru_cache
%global sum A backport of functools.lru_cache from Python 3.3 as published at ActiveState

Name:           python-%{srcname}
Version:        1.5
Release:        6%{?dist}
Summary:        %{sum}

License:        MIT
URL:            https://pypi.python.org/pypi/%{srcname}
Source0:        https://pypi.python.org/packages/source/b/%{dotname}/%{dotname}-%{version}.tar.gz

BuildArch:      noarch
BuildRequires:  python2-devel
BuildRequires:  python2-setuptools
# python2-setuptools is too old in EPEL7 for these
%if 0%{?fedora} || 0%{?rhel} > 7
BuildRequires:  python2-setuptools_scm
BuildRequires:  python2-pytest-runner
%endif

%description
%{sum}.

%package -n python2-%{srcname}
Summary:        %{sum}
%{?python_provide:%python_provide python2-%{srcname}}
Requires:	python2-backports

%description -n python2-%{srcname}
%{sum}.


%prep
%autosetup -n %{dotname}-%{version}


%build
%py2_build


%install
%py2_install


%check
# python2-setuptools is too old in EPEL7 to run tests
%if 0%{?fedora} || 0%{?rhel} > 7
%{__python2} setup.py test
%endif


%files -n python2-%{srcname}
%doc CHANGES.rst README.rst
%{python2_sitelib}/*
%exclude %{python2_sitelib}/backports/__init__.py*

%changelog
* Fri Jul 26 2019 Fedora Release Engineering <releng@fedoraproject.org> - 1.5-6
- Rebuilt for https://fedoraproject.org/wiki/Fedora_31_Mass_Rebuild

* Sat Feb 02 2019 Fedora Release Engineering <releng@fedoraproject.org> - 1.5-5
- Rebuilt for https://fedoraproject.org/wiki/Fedora_30_Mass_Rebuild

* Fri Jul 13 2018 Fedora Release Engineering <releng@fedoraproject.org> - 1.5-4
- Rebuilt for https://fedoraproject.org/wiki/Fedora_29_Mass_Rebuild

* Fri Feb 09 2018 Fedora Release Engineering <releng@fedoraproject.org> - 1.5-3
- Rebuilt for https://fedoraproject.org/wiki/Fedora_28_Mass_Rebuild

* Wed Feb 07 2018 Iryna Shcherbina <ishcherb@redhat.com> - 1.5-2
- Update Python 2 dependency declarations to new packaging standards
  (See https://fedoraproject.org/wiki/FinalizingFedoraSwitchtoPython3)

* Mon Feb 05 2018 Gwyn Ciesla <limburgher@gmail.com> - 1.5-1
- 1.5

* Fri Oct 06 2017 Gwyn Ciesla <limburgher@gmail.com> - 1.4-3
- Requires correction.

* Thu Jul 27 2017 Fedora Release Engineering <releng@fedoraproject.org> - 1.4-2
- Rebuilt for https://fedoraproject.org/wiki/Fedora_27_Mass_Rebuild


* Mon May 15 2017 Gwyn Ciesla <limburgher@gmail.com> - 1.4-1
- 1.4

* Thu Mar 9 2017 Orion Poplawski <orion@cora.nwra.com> - 1.2.1-4
- Do not run python 2 tests on EPEL7, setuptools is too old
- Drop python 3 package as this is a backport to python 2

* Sat Feb 11 2017 Fedora Release Engineering <releng@fedoraproject.org> - 1.2.1-3
- Rebuilt for https://fedoraproject.org/wiki/Fedora_26_Mass_Rebuild

* Mon Dec 19 2016 Miro Hrončok <mhroncok@redhat.com> - 1.2.1-2
- Rebuild for Python 3.6

* Wed Sep 28 2016 Jon Ciesla <limburgher@gmail.com> - 1.2.1-1
- Initial package.
