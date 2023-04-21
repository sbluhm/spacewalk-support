%global srcname Cython
%global _description \
This is a development version of Pyrex, a language\
for writing Python extension modules.\
\
For more info, see:\
\
    Doc/About.html for a description of the language\
    INSTALL.txt    for installation instructions\
    USAGE.txt      for usage instructions\
    Demos          for usage examples

Name:           python3-Cython
Version:        0.28.5
Release:        1%{?dist}
Summary:        A language for writing Python 3 extension modules

# Tools/site_scons/site_tools/pyext.py is MIT
License:        ASL 2.0 and MIT
URL:            http://www.cython.org
Source:         https://github.com/cython/cython/archive/%{version}/%{srcname}-%{version}.tar.gz

# For tests
BuildRequires:  libtool

%description %{_description}

%package -n python%{python3_pkgversion}-Cython
Summary:        A language for writing Python %{python3_version} extension modules
BuildRequires:  python%{python3_pkgversion}-devel
BuildRequires:  python%{python3_pkgversion}-coverage
BuildRequires:  python%{python3_pkgversion}-numpy

%description -n python%{python3_pkgversion}-Cython %{_description}

%package -n python%{python3_other_pkgversion}-Cython
Summary:        A language for writing Python %{python3_other_version} extension modules
BuildRequires:  python%{python3_other_pkgversion}-devel
BuildRequires:  python%{python3_other_pkgversion}-coverage
BuildRequires:  python%{python3_other_pkgversion}-numpy

%description -n python%{python3_other_pkgversion}-Cython %{_description}

%prep
%setup -q -n cython-%{version}
# Strip shbangs
sed -i -i '1{/^#!/d}' cython.py Cython/Debugger/{Cygdb,libpython}.py Cython/Build/Cythonize.py


%build
%py3_build
%py3_other_build


%install
%py3_other_install
mv %{buildroot}%{_bindir}/cython %{buildroot}%{_bindir}/cython%{python3_other_version}
mv %{buildroot}%{_bindir}/cythonize %{buildroot}%{_bindir}/cythonize%{python3_other_version}
mv %{buildroot}%{_bindir}/cygdb %{buildroot}%{_bindir}/cygdb%{python3_other_version}
rm -rf %{buildroot}%{python3_other_sitelib}/setuptools/tests
%py3_install
mv %{buildroot}%{_bindir}/cython %{buildroot}%{_bindir}/cython%{python3_version}
mv %{buildroot}%{_bindir}/cythonize %{buildroot}%{_bindir}/cythonize%{python3_version}
mv %{buildroot}%{_bindir}/cygdb %{buildroot}%{_bindir}/cygdb%{python3_version}
rm -rf %{buildroot}%{python3_sitelib}/setuptools/tests


%check
%{__python3} runtests.py -vv
%{__python3_other} runtests.py -vv


%files -n python%{python3_pkgversion}-Cython
%license COPYING.txt LICENSE.txt
%doc README.rst ToDo.txt USAGE.txt Demos Doc Tools
%{_bindir}/cython%{python3_version}
%{_bindir}/cythonize%{python3_version}
%{_bindir}/cygdb%{python3_version}
%{python3_sitearch}/Cython-%{version}-py%{python3_version}.egg-info/
%{python3_sitearch}/Cython/
%{python3_sitearch}/cython.py
%{python3_sitearch}/pyximport/
%{python3_sitearch}/__pycache__/cython.cpython-%{python3_version_nodots}*.py*


%files -n python%{python3_other_pkgversion}-Cython
%license COPYING.txt LICENSE.txt
%doc README.rst ToDo.txt USAGE.txt Demos Doc Tools
%{_bindir}/cython%{python3_other_version}
%{_bindir}/cythonize%{python3_other_version}
%{_bindir}/cygdb%{python3_other_version}
%{python3_other_sitearch}/Cython-%{version}-py%{python3_other_version}.egg-info/
%{python3_other_sitearch}/Cython/
%{python3_other_sitearch}/cython.py
%{python3_other_sitearch}/pyximport/
%{python3_other_sitearch}/__pycache__/cython.cpython-%{python3_other_version_nodots}*.py*


%changelog
* Sun Aug 11 2019 Orion Poplawski <orion@nwra.com> - 0.28.5-1
- Update to 0.28.5

* Thu Mar 07 2019 Troy Dawson <tdawson@redhat.com> - 0.28.4-4
- Re-enable tests

* Thu Mar 07 2019 Troy Dawson <tdawson@redhat.com> - 0.28.4-3
- Rebuilt to change main python from 3.4 to 3.6
- Disable tests for now

* Wed Aug 08 2018 Carl George <carl@george.computer> - 0.28.4-2
- Enable python36 subpackage

* Sun Jul 29 2018 Orion Poplawski - 0.28.4-1
- Update to 0.28.4

* Mon Mar 28 2016 Orion Poplawski - 0.23.5-1
- Update to 0.23.5
- Macro usage cleanup
- Fix license tag
- Fix line endings
- Remove unneeded shbangs

* Thu Mar 3 2016 Orion Poplawski - 0.23.4-2
- Fixup files

* Mon Jan 11 2016 Orion Poplawski - 0.23.4-1
- Initial EPEL7 package
