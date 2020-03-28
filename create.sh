createrepo --update --workers=4 .
git add *
git add repodata/*
git commit
git push
dnf clean all
