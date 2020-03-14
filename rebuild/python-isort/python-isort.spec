%global modname isort

Name:               python-%{modname}
Version:            4.2.5
Release:            9%{?dist}
Summary:            Python utility / library to sort Python imports

License:            MIT
URL:                https://github.com/timothycrosley/%{modname}
Source0:            %{url}/archive/%{version}/%{modname}-%{version}.tar.gz
BuildArch:          noarch

%description
%{summary}.

%package -n python2-%{modname}
Summary:            %{summary}
%{?python_provide:%python_provide python2-%{modname}}
BuildRequires:      python2-devel
BuildRequires:      python2-setuptools
BuildRequires:      python2-mock
BuildRequires:      python2-pytest

%description -n python2-%{modname}
%{summary}.

Python 2 version.

%package -n python%{python3_pkgversion}-%{modname}
Summary:            %{summary}
%{?python_provide:%python_provide python%{python3_pkgversion}-%{modname}}
BuildRequires:      python%{python3_pkgversion}-devel
BuildRequires:      python%{python3_pkgversion}-setuptools
BuildRequires:      python%{python3_pkgversion}-mock
BuildRequires:      python%{python3_pkgversion}-pytest

%description -n python%{python3_pkgversion}-%{modname}
%{summary}.

Python %{python3_pkgversion} version.

%prep
%autosetup -n %{modname}-%{version}

# Drop shebang
sed -i -e '1{\@^#!.*@d}' %{modname}/main.py
chmod -x LICENSE

%build
%py2_build
%py3_build

%install
%py2_install
mv %{buildroot}%{_bindir}/%{modname}{,-%{python2_version}}
ln -s %{modname}-%{python2_version} %{buildroot}%{_bindir}/%{modname}-2
%py3_install
mv %{buildroot}%{_bindir}/%{modname}{,-%{python3_version}}
ln -s %{modname}-%{python3_version} %{buildroot}%{_bindir}/%{modname}-%{python3_pkgversion}

ln -s %{modname}-2 %{buildroot}%{_bindir}/%{modname}

%check
%{__python2} setup.py test
%{__python3} setup.py test

%files -n python2-%{modname}
%doc README.rst *.md
%license LICENSE
%{_bindir}/%{modname}
%{_bindir}/%{modname}-2
%{_bindir}/%{modname}-%{python2_version}
%{python2_sitelib}/%{modname}/
%{python2_sitelib}/%{modname}-*.egg-info/

%files -n python%{python3_pkgversion}-%{modname}
%doc README.rst *.md
%license LICENSE
%{_bindir}/%{modname}-%{python3_pkgversion}
%{_bindir}/%{modname}-%{python3_version}
%{python3_sitelib}/%{modname}/
%{python3_sitelib}/%{modname}-*.egg-info/

%changelog
* Fri Mar 08 2019 Troy Dawson <tdawson@redhat.com> - 4.2.5-9
- Rebuilt to change main python from 3.4 to 3.6

* Thu Mar 9 2017 Orion Poplawski <orion@cora.nwra.com> - 4.2.5-8
- Enable EPEL7 build

* Sat Feb 11 2017 Fedora Release Engineering <releng@fedoraproject.org> - 4.2.5-7
- Rebuilt for https://fedoraproject.org/wiki/Fedora_26_Mass_Rebuild

* Mon Dec 12 2016 Stratakis Charalampos <cstratak@redhat.com> - 4.2.5-6
- Rebuild for Python 3.6

* Wed Aug 10 2016 Igor Gnatenko <ignatenko@redhat.com> - 4.2.5-5
- Modernize spec

* Tue Aug 09 2016 Jon Ciesla <limburgher@gmail.com> - 4.2.5-4
- Fix python binary versioning again.

* Tue Aug 09 2016 Jon Ciesla <limburgher@gmail.com> - 4.2.5-3
- Fix python binary versioning again.

* Mon Aug 08 2016 Jon Ciesla <limburgher@gmail.com> - 4.2.5-2
- Switch to github.
- Fix python binary versioning.
- Run tests.

* Fri Jul 29 2016 Jon Ciesla <limburgher@gmail.com> - 4.2.5-1
- Initial package.
