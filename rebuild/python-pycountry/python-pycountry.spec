%global srcname pycountry

Name:           python-%{srcname}
Version:        19.8.18
Release:        1%{?dist}
Summary:        ISO country, subdivision, language, currency and script definitions and their translations

License:        LGPLv2
URL:            https://bitbucket.org/flyingcircus/pycountry
Source0:        %pypi_source
# Rebased from Debian:
Patch0001:      00-use_system_iso-codes.patch

BuildArch:      noarch

BuildRequires:  iso-codes >= 4.1
BuildRequires:  python3-devel
BuildRequires:  python3dist(setuptools)
BuildRequires:  python3dist(pytest)

%description
pycountry provides the ISO databases for the standards:
* 639-3 Languages
* 3166 Countries
* 3166-3 Deleted countries
* 3166-2 Subdivisions of countries
* 4217 Currencies
* 15924 Scripts


%package -n     python3-%{srcname}
Summary:        %{summary}
%{?python_provide:%python_provide python3-%{srcname}}

Requires:       iso-codes >= 4.1

%description -n python3-%{srcname}
pycountry provides the ISO databases for the standards:
* 639-3 Languages
* 3166 Countries
* 3166-3 Deleted countries
* 3166-2 Subdivisions of countries
* 4217 Currencies
* 15924 Scripts


%prep
%autosetup -n %{srcname}-%{version} -p1

# Remove bundled egg-info
rm -rf src/%{srcname}.egg-info

# Remove bundled iso-codes data
rm -rf src/%{srcname}/{databases,locales}


%build
%py3_build


%install
%py3_install


%check
PYTHONPATH=%{buildroot}%{python3_sitelib} PYTHONDONTWRITEBYTECODE=1 \
    %{__python3} -m pytest --pyargs pycountry


%files -n python3-%{srcname}
%doc README.rst HISTORY.txt
%license LICENSE.txt
%{python3_sitelib}/%{srcname}
%{python3_sitelib}/%{srcname}-%{version}-py?.?.egg-info


%changelog
* Mon Aug 19 2019 Elliott Sales de Andrade <quantum.analyst@gmail.com> - 19.8.18-1
- Update to latest version

* Fri Jul 26 2019 Fedora Release Engineering <releng@fedoraproject.org> - 18.12.8-3
- Rebuilt for https://fedoraproject.org/wiki/Fedora_31_Mass_Rebuild

* Sat Feb 02 2019 Fedora Release Engineering <releng@fedoraproject.org> - 18.12.8-2
- Rebuilt for https://fedoraproject.org/wiki/Fedora_30_Mass_Rebuild

* Thu Dec 13 2018 Elliott Sales de Andrade <quantum.analyst@gmail.com> - 18.12.8-1
- Initial package.
