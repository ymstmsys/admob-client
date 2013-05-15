#!/bin/bash

group=com.github.ymstmsys.admob
artifact=admob-client
version=`xpath pom.xml project/version 2>/dev/null | sed s/\<version\>//g| sed s/\<\\\\/version\>//g`
finalName=${artifact}-${version}.jar

url=http://maven.zariba.eu/archiva/repository/zariba-maven-release

#http://maven.zariba.eu/archiva/repository/zariba-maven-release
#http://maven.zariba.eu/archiva/repository/zariba-maven-milestone

repository=zariba-maven-release

mvn clean package -DskipTests=true -Dmaven.test.skip=true
mvn -s ../git/ecosystem/src/parent/settings.xml deploy:deploy-file -Dfile=target/$finalName -DgroupId=$group \
    -DartifactId=$artifact -Dversion=$version -Dpackaging=jar -DrepositoryId=$repository\
    -Durl=$url