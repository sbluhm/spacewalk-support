Name:		python-unversioned-command
Version:	3.6.8
Release:	15%{?dist}
Summary:	Summary: The "python" command that runs Python 3
License:	Copyright 2020 Stefan Bluhm, Germany
URL:		https://github.com/sbluhm/spacewalk-support/
Requires:	python3

%description
This package contains /usr/bin/python - the "python" command that runs Python 3.
NOTE: CUSTOM PACKAGE VERSION! This package is not part of the python2 build but
a manual creation to avoid unneeded dependencies. It will work with any Python 3
version. Main purpose is to provide the package python-unversioned-command for
RHEL8.


%build

%install
install -m 755 -d $RPM_BUILD_ROOT/usr/bin
ln -s python3 $RPM_BUILD_ROOT/usr/bin/python

%files
/usr/bin/python


%changelog

