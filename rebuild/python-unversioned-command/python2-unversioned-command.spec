Name:		python-unversioned-command
Version:	2.7.16
Release:	12%{?dist}
Summary:	Summary: The "python" command that runs Python 2
License:	Copyright 2020 Stefan Bluhm, Germany
URL:		https://github.com/sbluhm/spacewalk-support/
Requires:	python2

%description
This package contains /usr/bin/python - the "python" command that runs Python 2.
NOTE: CUSTOM PACKAGE VERSION! This package is not part of the python2 build but
a manual creation to avoid unneeded dependencies. It will work with any Python 2
version. Main purpose is to provide the package python-unversioned-command for
RHEL8.


%build

%install
install -m 755 -d $RPM_BUILD_ROOT/usr/bin
ln -s python2 $RPM_BUILD_ROOT/usr/bin/python

%files
/usr/bin/python


%changelog

