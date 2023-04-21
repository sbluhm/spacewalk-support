%{!?python_sitelib: %define python_sitelib %(%{__python} -c "from distutils.sysconfig import get_python_lib; print get_python_lib()")}
Name:          jabberpy
Version:       0.5
# Used like this because upstream releases like 0.5-0
Release:       0.27%{?dist}
Summary:       Python xmlstream and jabber IM protocol libs

Group:         Development/Libraries
License:       LGPLv2+
URL:           http://sourceforge.net/projects/jabberpy/
Source0:       http://downloads.sf.net/sourceforge/%{name}/%{name}-%{version}-0.tar.gz
Patch0:        jabberpy-no-init.patch
Patch1:        jabberpy-clean-sockets.patch
Patch2:        jabberpy-ipv6.patch
Patch3:        jabberpy-sha-deprecation.patch
Patch4:        jabberpy-proxy-read.patch

BuildRoot:     %{_tmppath}/%{name}-%{version}-%{release}-root-%(%{__id_u} -n)
BuildArch:     noarch

BuildRequires: python-devel
Requires:      python

%description
jabber.py is a Python module for the jabber instant messaging
protocol. jabber.py deals with the xml parsing and socket code,
leaving the programmer to concentrate on developing quality jabber
based applications with Python.

%prep
%setup -q -n %{name}-%{version}-0
chmod -x examples/*.py
%patch0 -p1 -b .no-init
%patch1 -p1 -b .clean-sockets
%patch2 -p0 -b .ipv6
%patch3 -p0 -b .sha-deprecation
%patch4 -p1 -b .proxy

%build
%{__python} setup.py  build

%install
rm -rf $RPM_BUILD_ROOT
%{__python} setup.py install --root=$RPM_BUILD_ROOT 

%clean
rm -rf $RPM_BUILD_ROOT

%files
%defattr(-,root,root)
%doc examples README
%{python_sitelib}/*


%changelog
* Tue Jul  8 2014 Milan Zazrivec <mzazrivec@redhat.com> 0.5-0.27
- fix sha module deprecation warning
- use blocking read in initial communication with http proxy

* Thu Feb 14 2013 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 0.5-0.26
- Rebuilt for https://fedoraproject.org/wiki/Fedora_19_Mass_Rebuild

* Thu Jul 19 2012 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 0.5-0.25
- Rebuilt for https://fedoraproject.org/wiki/Fedora_18_Mass_Rebuild

* Fri Jan 13 2012 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 0.5-0.24
- Rebuilt for https://fedoraproject.org/wiki/Fedora_17_Mass_Rebuild

* Fri Sep 23 2011 Milan Zazrivec <mzazrivec@redhat.com> 0.5-0.23
- 670881 - IPv6 support for jabberpy

* Wed Feb 09 2011 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 0.5-0.22
- Rebuilt for https://fedoraproject.org/wiki/Fedora_15_Mass_Rebuild

* Wed Jul 21 2010 David Malcolm <dmalcolm@redhat.com> - 0.5-0.21
- Rebuilt for https://fedoraproject.org/wiki/Features/Python_2.7/MassRebuild

* Fri Jul 24 2009 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 0.5-0.20
- Rebuilt for https://fedoraproject.org/wiki/Fedora_12_Mass_Rebuild

* Wed Feb 25 2009 Fedora Release Engineering <rel-eng@lists.fedoraproject.org> - 0.5-0.19
- Rebuilt for https://fedoraproject.org/wiki/Fedora_11_Mass_Rebuild

* Sat Nov 29 2008 Ignacio Vazquez-Abrams <ivazqueznet+rpm@gmail.com> - 0.5-0.18
- Rebuild for Python 2.6

* Fri Oct 24 2008 Michael Stahnke <stahnma@fedoraproject.org> 0.5.0.17
- Minor Spec tweaks for review

* Mon Oct 10 2008 Michael Stahnke <stahnma@fedoraproject.org> 0.5-0.16
- Clean up for Fedora Review and submission

* Wed Sep  3 2008 Jesus Rodriguez <jesusr@redhat.com> 0.5-0.15
- remove reliance on external version file

* Tue Oct 09 2007 Pradeep Kilambi <pkilambi@redhat.com>
- clean dangling ports left out by jabberpy

* Mon Jun 14 2004 Mihai Ibanescu <misa@redhat.com>
- Initial build
- Patched to add a __init__ file
