#!/bin/bash

JAR_NAME=app
VERSION=1.0.0-SNAPSHOT

./mvnw clean install
java -jar target/${JAR_NAME}-${VERSION}.jar
