export VERSION=2.8
export RELEASE=1
export SHORTNAME=ssl-cert-check
export LOCATION=/root/spacewalk/projects
rm -Rf ${LOCATION}/spacewalk-${SHORTNAME}-${VERSION}
cp -R ${LOCATION}/${SHORTNAME} ${LOCATION}/spacewalk-${SHORTNAME}-${VERSION}
rm -f ~/rpmbuild/SOURCES/spacewalk-${SHORTNAME}-${VERSION}.tar.gz;
cd ${LOCATION}
tar cf ~/rpmbuild/SOURCES/spacewalk-${SHORTNAME}-${VERSION}.tar.gz spacewalk-${SHORTNAME}-${VERSION}
rm -Rf ${LOCATION}/spacewalk-${SHORTNAME}-${VERSION}
rpmbuild -ba ${LOCATION}/${SHORTNAME}/spacewalk-${SHORTNAME}.spec
#cd ~/spacewalk
#git tag -d spacewalk-${SHORTNAME}-${VERSION}-${RELEASE}
#git push --delete origin spacewalk-${SHORTNAME}-${VERSION}-${RELEASE}
#git push origin :refs/tags/spacewalk-${SHORTNAME}-${VERSION}-${RELEASE}
#git tag spacewalk-${SHORTNAME}-${VERSION}-${RELEASE}
#git push origin --tags
