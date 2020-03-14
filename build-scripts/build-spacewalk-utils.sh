rm -Rf /root/spacewalk/utils-2.10.6
cp -R /root/spacewalk/utils /root/spacewalk/spacewalk-utils-2.10.6
rm -f ~/rpmbuild/SOURCES/spacewalk-utils-2.10.6.tar.gz;
cd /root/spacewalk/
tar cf ~/rpmbuild/SOURCES/spacewalk-utils-2.10.6.tar.gz spacewalk-utils-2.10.6
rm -Rf /root/spacewalk/spacewalk-utils-2.10.6
rpmbuild -ba ~/spacewalk/utils/spacewalk-utils.spec
#cd ~/spacewalk
#git tag -d spacewalk-utils-2.10.6
#git push origin --tags
#git tag spacewalk-utils-2.10.6

