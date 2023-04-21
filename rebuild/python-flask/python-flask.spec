%if 0%{?rhel} > 7
# Disable python2 build by default
%bcond_with python2
%else
%bcond_without python2
%endif

%global modname flask
%global srcname Flask

Name:           python-%{modname}
Version:        0.12.2
Release:        3%{?dist}
Epoch:          1
Summary:        A micro-framework for Python based on Werkzeug, Jinja 2 and good intentions

License:        BSD
URL:            http://flask.pocoo.org/
Source0:        https://files.pythonhosted.org/packages/source/%(n=%{srcname}; echo ${n:0:1})/%{srcname}/%{srcname}-%{version}.tar.gz

# rhbz#1623180
# Backported just this patch because 0.12.3+ have added other changes we cannot take.
Patch0001:      0001-detect-UTF-encodings-when-loading-json.patch

BuildArch:      noarch

%global _description \
Flask is called a “micro-framework” because the idea to keep the core\
simple but extensible. There is no database abstraction layer, no form\
validation or anything else where different libraries already exist\
that can handle that. However Flask knows the concept of extensions\
that can add this functionality into your application as if it was\
implemented in Flask itself. There are currently extensions for object\
relational mappers, form validation, upload handling, various open\
authentication technologies and more.

%description %{_description}

%if %{with python2}
%package -n python2-%{modname}
Summary:        %{summary}
%{?python_provide:%python_provide python2-%{modname}}
BuildRequires:  python2-devel
BuildRequires:  python2-setuptools
BuildRequires:  python2-pytest
%if 0%{?fedora} >= 26 || 0%{?rhel} > 7
BuildRequires:  python2-werkzeug
Requires:       python2-werkzeug
BuildRequires:  python2-jinja2
Requires:       python2-jinja2
BuildRequires:  python2-click
Requires:       python2-click
BuildRequires:  python2-itsdangerous
Requires:       python2-itsdangerous
%else
BuildRequires:  python-werkzeug
Requires:       python-werkzeug
BuildRequires:  python-jinja2
Requires:       python-jinja2
BuildRequires:  python-click
Requires:       python-click
BuildRequires:  python-itsdangerous
Requires:       python-itsdangerous
%endif
%description -n python2-%{modname} %{_description}

Python 2 version.
%endif # with python2

%package -n python%{python3_pkgversion}-%{modname}
Summary:        %{summary}
%{?python_provide:%python_provide python%{python3_pkgversion}-%{modname}}
BuildRequires:  python%{python3_pkgversion}-devel
BuildRequires:  python%{python3_pkgversion}-setuptools
BuildRequires:  python%{python3_pkgversion}-pytest
BuildRequires:  python%{python3_pkgversion}-jinja2
BuildRequires:  python%{python3_pkgversion}-werkzeug
BuildRequires:  python%{python3_pkgversion}-itsdangerous
BuildRequires:  python%{python3_pkgversion}-click
Requires:       python%{python3_pkgversion}-jinja2
Requires:       python%{python3_pkgversion}-werkzeug
Requires:       python%{python3_pkgversion}-itsdangerous
Requires:       python%{python3_pkgversion}-click

%description -n python%{python3_pkgversion}-%{modname} %{_description}

Python 3 version.

%package doc
Summary:        Documentation for %{name}
Obsoletes:      python%{python3_pkgversion}-%{modname}-doc < 1:0.11.1-3
BuildRequires:  python3-sphinx

%description doc
Documentation and examples for %{name}.

%prep
%autosetup -p1 -n %{srcname}-%{version}
rm -rf examples/flaskr/
rm -rf examples/minitwit/

%build
%if %{with python2}
%py2_build
%endif # with python2
%py3_build
PYTHONPATH=`pwd` sphinx-build-3 -b html docs/ docs/_build/html/
rm -rf docs/_build/html/{.buildinfo,.doctrees}

%install
%if %{with python2}
%py2_install
mv %{buildroot}%{_bindir}/%{modname}{,-%{python2_version}}
ln -s %{modname}-%{python2_version} %{buildroot}%{_bindir}/%{modname}-2
%endif # with python2

%py3_install
mv %{buildroot}%{_bindir}/%{modname}{,-%{python3_version}}
ln -s %{modname}-%{python3_version} %{buildroot}%{_bindir}/%{modname}-3

%if %{with python2}
ln -sf %{modname}-2 %{buildroot}%{_bindir}/%{modname}
%else
ln -sf %{modname}-3 %{buildroot}%{_bindir}/%{modname}
%endif # with python2

%check
export LC_ALL=C.UTF-8
#%if %{with python2}
#PYTHONPATH=%{buildroot}%{python2_sitelib} py.test-%{python2_version} -v
#%endif # with python2
#PYTHONPATH=%{buildroot}%{python3_sitelib} py.test-%{python3_version} -v || :

%if %{with python2}
%files -n python2-%{modname}
%license LICENSE
%doc CHANGES README
%{_bindir}/%{modname}-2
%{_bindir}/%{modname}-%{python2_version}
%{python2_sitelib}/%{srcname}-*.egg-info/
%{python2_sitelib}/%{modname}/

%{_bindir}/%{modname}
%endif # with python2

%files -n python%{python3_pkgversion}-%{modname}
%license LICENSE
%doc CHANGES README
%{_bindir}/%{modname}-3
%{_bindir}/%{modname}-%{python3_version}
%{python3_sitelib}/%{srcname}-*.egg-info/
%{python3_sitelib}/%{modname}/

%if %{without python2}
%{_bindir}/%{modname}
%endif # without python2

%files doc
%license LICENSE
%doc docs/_build/html examples

%changelog
* Wed Sep 05 2018 Brian C. Lane <bcl@redhat.com> - 0.12.2-3
- detect UTF encodings when loading json (CVE-2018-1000656)
  Resolves: rhbz#1623180

* Wed Jun 20 2018 Charalampos Stratakis <cstratak@redhat.com> - 1:0.12.2-2
- Conditionalize the python2 subpackage

* Thu Feb 15 2018 itamar <itamar@ispbrasil.com.br> - 1:0.12.2-1
- new version

* Fri Feb 09 2018 Fedora Release Engineering <releng@fedoraproject.org> - 1:0.11.1-8
- Rebuilt for https://fedoraproject.org/wiki/Fedora_28_Mass_Rebuild

* Thu Jan 18 2018 Iryna Shcherbina <ishcherb@redhat.com> - 1:0.11.1-7
- Update Python 2 dependency declarations to new packaging standards
  (See https://fedoraproject.org/wiki/FinalizingFedoraSwitchtoPython3)

* Thu Jul 27 2017 Fedora Release Engineering <releng@fedoraproject.org> - 1:0.11.1-6
- Rebuilt for https://fedoraproject.org/wiki/Fedora_27_Mass_Rebuild

* Sat Feb 11 2017 Fedora Release Engineering <releng@fedoraproject.org> - 1:0.11.1-5
- Rebuilt for https://fedoraproject.org/wiki/Fedora_26_Mass_Rebuild

* Tue Dec 13 2016 Stratakis Charalampos <cstratak@redhat.com> - 1:0.11.1-4
- Rebuild for Python 3.6
- Have rpmbuild to not fail on python3 test failures

* Mon Aug 22 2016 Igor Gnatenko <ignatenko@redhat.com> - 1:0.11.1-3
- Fix FTBFS
- Ton of fixes in spec

* Tue Aug 16 2016 Ricky Elrod <relrod@redhat.com> - 1:0.11.1-2
- Attempt a completely fresh build with new NVR.

* Tue Aug 16 2016 Ricky Elrod <relrod@redhat.com> - 1:0.11.1-1
- Latest upstream release.

* Tue Jul 19 2016 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 1:0.10.1-9
- https://fedoraproject.org/wiki/Changes/Automatic_Provides_for_Python_RPM_Packages

* Thu Feb 04 2016 Fedora Release Engineering <releng@fedoraproject.org> - 1:0.10.1-8
- Rebuilt for https://fedoraproject.org/wiki/Fedora_24_Mass_Rebuild

* Wed Oct 14 2015 Robert Kuska <rkuska@redhat.com> - 1:0.10.1-7
- Rebuilt for Python3.5 rebuild

* Thu Jun 18 2015 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 1:0.10.1-6
- Rebuilt for https://fedoraproject.org/wiki/Fedora_23_Mass_Rebuild

* Sat Jun 07 2014 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 1:0.10.1-5
- Rebuilt for https://fedoraproject.org/wiki/Fedora_21_Mass_Rebuild

* Tue May 13 2014 Bohuslav Kabrda <bkabrda@redhat.com> - 1:0.10.1-4
- Rebuilt for https://fedoraproject.org/wiki/Changes/Python_3.4
- Minor fix to rhel macro logic

* Mon Jul 29 2013 Haïkel Guémar <hguemar@fedoraproject.org> - 1:0.10.1-3
- fix wrong requires on sphinx (RHBZ #989361)

* Sat Jul 20 2013 Ricky Elrod <codeblock@fedoraproject.org> - 1:0.10.1-2
- Nuke a Python3 specific file owned by python3-setuptools.

* Sat Jun 15 2013 Haïkel Guémar <hguemar@fedoraproject.org> - 1:0.10.1-1
- upstream 0.10.1

* Thu Feb 14 2013 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 1:0.9-6
- Rebuilt for https://fedoraproject.org/wiki/Fedora_19_Mass_Rebuild

* Fri Aug 17 2012 Ricky Elrod <codeblock@fedoraproject.org> - 0.9-5
- Add epoch to subpackage Requires.

* Wed Aug 8 2012 Ricky Elrod <codeblock@fedoraproject.org> - 0.9-4
- Fix changelog messup.

* Wed Aug 8 2012 Ricky Elrod <codeblock@fedoraproject.org> - 0.9-3
- Unified spec for EL6 and Fedora

* Sat Jul 21 2012 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 0.9.0-2
- Rebuilt for https://fedoraproject.org/wiki/Fedora_18_Mass_Rebuild

* Mon Jul  2 2012 Haïkel Guémar <hguemar@fedoraproject.org> - 0.9.0-1
- upstream 0.9
- spec cleanups

* Sun Jul  1 2012 Haïkel Guémar <hguemar@fedoraproject.org> - 0.8.1-1
- upstream 0.8.1 (minor bugfixes)

* Wed Jan 25 2012 Haïkel Guémar <hguemar@fedoraproject.org> - 0.8.0-1
- upstream 0.8

* Sat Jan 14 2012 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 0.7.2-3
- Rebuilt for https://fedoraproject.org/wiki/Fedora_17_Mass_Rebuild

* Wed Nov 16 2011 Dan Young <dyoung@mesd.k12.or.us> - 0.7.2-2
- don't own easy-install.pth

* Fri Jul 22 2011 Steve Milner <smilner@fedoraproject.org> - 0.7.2-1
- update for upstream release

* Thu Feb 24 2011 Dan Young <dyoung@mesd.k12.or.us> - 0.6.1-2
- fix rpmlint spelling warning
- BR python2-devel rather than python-devel
- run test suite in check

* Tue Feb 22 2011 Dan Young <dyoung@mesd.k12.or.us> - 0.6.1-1
- Initial package
