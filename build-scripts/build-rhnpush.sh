rm -Rf /root/spacewalk/client/tools/rhnpush-5.5.120
cp -R /root/spacewalk/client/tools/rhnpush /root/spacewalk/client/tools/rhnpush-5.5.120
rm -f ~/rpmbuild/SOURCES/rhnpush-5.5.120.tar.gz;
cd /root/spacewalk/client/tools
tar cf ~/rpmbuild/SOURCES/rhnpush-5.5.120.tar.gz rhnpush-5.5.120
rm -Rf /root/spacewalk/client/tools/rhnpush-5.5.120
rpmbuild -ba ~/spacewalk/client/tools/rhnpush/rhnpush.spec
cd ~/spacewalk
git tags -d rhnpush-5.5.120-1
git push origin --tags
#git tags rhnpush-5.5.120-1

