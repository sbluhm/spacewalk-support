rm -Rf /root/spacewalk/spacewalk-java-2.10.15
cp -R /root/spacewalk/java /root/spacewalk/spacewalk-java-2.10.15
rm -f ~/rpmbuild/SOURCES/spacewalk-java-2.10.15.tar.gz;
cd /root/spacewalk/
tar cf ~/rpmbuild/SOURCES/spacewalk-java-2.10.15.tar.gz spacewalk-java-2.10.15
rm -Rf /root/spacewalk/spacewalk-java-2.10.15
rpmbuild -ba ~/spacewalk/java/spacewalk-java.spec
#cd ~/spacewalk
#git tag -d spacewalk-java-2.10.15
#git push origin --tags
#git tag spacewalk-java-2.10.15

