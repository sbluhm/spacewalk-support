export VERSION=2.10.26
export RELEASE=1
rm -Rf /root/spacewalk/backend-${VERSION}
cp -R /root/spacewalk/backend /root/spacewalk/spacewalk-backend-${VERSION}
rm -f ~/rpmbuild/SOURCES/spacewalk-backend-${VERSION}.tar.gz;
cd /root/spacewalk/
tar cf ~/rpmbuild/SOURCES/spacewalk-backend-${VERSION}.tar.gz spacewalk-backend-${VERSION}
rm -Rf /root/spacewalk/spacewalk-backend-${VERSION}
rpmbuild -ba ~/spacewalk/utils/spacewalk-backend.spec
#cd ~/spacewalk
git tag -d spacewalk-backend-${VERSION}-${RELEASE}
#git push --delete origin spacewalk-backend-${VERSION}-${RELEASE}
git push origin :refs/tags/spacewalk-backend-${VERSION}-${RELEASE}
git tag spacewalk-backend-${VERSION}-${RELEASE}
git push origin --tags
