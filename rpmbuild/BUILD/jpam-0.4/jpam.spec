# We don't need pam_module_rpms, it seems; the original makefile looked
# like it wants to know all pam modules, but that doesn't seem
# necessary. If using Pam causes weird linkage errors, we need to reinstate
# this line and uncomment the ones that use this macro
#%define pam_module_rpms pam pam_krb5 pam_smb nss_ldap samba-common
%define jpackage_run_jars antlr jakarta-commons-beanutils jakarta-commons-collections jakarta-commons-logging regexp
%define jpackage_build_jars checkstyle junit
%define jpackage_jars %jpackage_run_jars %jpackage_build_jars
%define _jvmdir %{_libdir}/jvm/java-ibm

Summary: A JNI Wrapper for the Unix pam(8) subsystem and a JAAS bridge
Name: jpam
Version: 0.3
Release: 1
License: Apache Software License, v. 1.1
Group: Application/Development
URL: http://jpam.sourceforge.net/
Source0: %{name}-%{version}-src.zip
BuildRoot: %{_tmppath}/%{name}-%{version}-%{release}-buildroot

#Requires: %pam_module_rpms
Requires: %jpackage_run_jars
BuildRequires: java-1.4.2-ibm-devel
BuildRequires: %jpackage_jars
#BuildRequires: %pam_module_rpms
BuildRequires: gcc make
BuildRequires: pam-devel

%description 
JPam provides a class to access the Unix pam(8) subsystem from
Java, and wraps it in a JAAS LoginModule

%package javadoc
Summary:       Javadoc for %{name}
Group:         Development/Documentation

%description javadoc
Javadoc for %{name}.

%prep
%setup -q
cp -p %{SOURCE1} .

rm -Rfv tools/*.jar
build-jar-repository -p tools/ %jpackage_jars

%build
#export PAM_MODULES=$(rpm -ql %pam_module_rpms | grep '^/lib/security/.*.so$' | sort -u | tr '\n' ' ')
ant shared-object dist-jar javadoc

%install
rm -rf $RPM_BUILD_ROOT

# jar
install -d -m 755 $RPM_BUILD_ROOT%{_javadir}
install -m 644 build/%{name}-%{version}.jar $RPM_BUILD_ROOT%{_javadir}/%{name}-%{version}.jar
(cd $RPM_BUILD_ROOT%{_javadir} && for jar in *-%{version}*; do ln -sf ${jar} `echo $jar| sed  "s|-%{version}||g"`; done)

install -d -m 755 $RPM_BUILD_ROOT%{_docdir}/%{name}-%{version}
install -m 644 src/dist/* $RPM_BUILD_ROOT%{_docdir}/%{name}-%{version}
install -D -m 755 build/gen-src/c/libjpam.so $RPM_BUILD_ROOT%{_jvmdir}/jre/bin/libjpam.so

# javadoc
install -d -m 755 $RPM_BUILD_ROOT%{_javadocdir}/%{name}-%{version}
cp -pr site/documentation/javadoc/* $RPM_BUILD_ROOT%{_javadocdir}/%{name}-%{version}

%clean
rm -rf $RPM_BUILD_ROOT

%post javadoc
rm -f %{_javadocdir}/%{name}
ln -s %{name}-%{version} %{_javadocdir}/%{name}

%postun javadoc
if [ "$1" = "0" ]; then
    rm -f %{_javadocdir}/%{name}
fi

%files
%defattr(-,root,root,-)
%{_javadir}/*
%{_jvmdir}/jre/bin/libjpam.so

%doc
%{_docdir}/*

%files javadoc
%defattr(0644,root,root,0755)
%{_javadocdir}/%{name}-%{version}

%changelog
* Fri Apr  1 2005  <dlutter@redhat.com> 
- Initial build.


