#!/bin/sh
mvn clean install
echo "clean install done"
mvn exec:java -Dexec.mainClass=com.zopa.main.App -Dexec.args="src/test/resources/$1 $2"

