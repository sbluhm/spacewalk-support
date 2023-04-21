%global srcname lazy-object-proxy
%global sum A fast and thorough lazy object proxy

Name:           python-%{srcname}
Version:        1.2.2
Release:        2%{?dist}
Summary:        %{sum}

License:        BSD
Url:            https://github.com/ionelmc/python-%{srcname}
Source0:        https://github.com/ionelmc/python-%{srcname}/archive/v%{version}/%{srcname}-%{version}.tar.gz

BuildRequires:  python2-devel python2-setuptools
BuildRequires:  python3-devel python3-setuptools

%description
A fast and thorough lazy object proxy.

%package -n python2-%{srcname}
Summary:        %{sum}
%{?python_provide:%python_provide python2-%{srcname}}

%description -n python2-%{srcname}
A fast and thorough lazy object proxy.


%package -n python3-%{srcname}
Summary:        %{sum}
%{?python_provide:%python_provide python3-%{srcname}}

%description -n python3-%{srcname}
A fast and thorough lazy object proxy.


%prep
%autosetup -n python-%{srcname}-%{version}

%build
%py2_build
%py3_build

%install
# Must do the python2 install first because the scripts in /usr/bin are
# overwritten with every setup.py install, and in general we want the
# python3 version to be the default.
%py2_install
%py3_install

%check
%{__python2} setup.py test
%{__python3} setup.py test

# Note that there is no %%files section for the unversioned python module if we are building for several python runtimes
%files -n python2-%{srcname}
%license LICENSE
%doc README.rst
%{python2_sitearch}/*
%attr(0755, root, root) %{python2_sitearch}/lazy_object_proxy/*.so
%exclude %{python2_sitearch}/lazy_object_proxy/cext.c

%files -n python3-%{srcname}
%license LICENSE
%doc README.rst
%{python3_sitearch}/*
%attr(0755, root, root) %{python3_sitearch}/lazy_object_proxy/*.so
%exclude %{python3_sitearch}/lazy_object_proxy/cext.c

%changelog
* Fri Mar 08 2019 Troy Dawson <tdawson@redhat.com> - 1.2.2-2
- Rebuilt to change main python from 3.4 to 3.6

* Thu Mar 09 2017 Orion Poplawski <orion@cora.nwra.com> - 1.2.2-1
- Update to 1.2.2
- Enable build for EPEL

* Sat Feb 11 2017 Fedora Release Engineering <releng@fedoraproject.org> - 1.2.1-6
- Rebuilt for https://fedoraproject.org/wiki/Fedora_26_Mass_Rebuild

* Fri Dec 09 2016 Charalampos Stratakis <cstratak@redhat.com> - 1.2.1-5
- Rebuild for Python 3.6

* Tue Jul 19 2016 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 1.2.1-4
- https://fedoraproject.org/wiki/Changes/Automatic_Provides_for_Python_RPM_Packages

* Thu Feb 04 2016 Fedora Release Engineering <releng@fedoraproject.org> - 1.2.1-3
- Rebuilt for https://fedoraproject.org/wiki/Fedora_24_Mass_Rebuild

* Fri Dec 04 2015 Brian C. Lane <bcl@redhat.com> 1.2.1-2
- Fix the permissions on the cext.so file

* Tue Dec 01 2015 Brian C. Lane <bcl@redhat.com> 1.2.1-1
- Initial creation

