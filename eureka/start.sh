#!/bin/bash

echo "######## BEGIN spring boot jar ##################";

function help() {
    echo $1;
    echo -e "Environment parameters:"
    echo -e "\t\t [ARTIFACT_ID] -> mandatory, artifactId of the maven artifact"
    echo -e "\t\t [VERSION] -> mandatory, version of the maven artifact"
    echo -e "\t\t [JAVA_OPTS] -> optional, java options"
    exit -1;
}

function logParams() {
    echo "params passed to script... "
    echo "[ARTIFACT_ID] =\"${ARTIFACT_ID}\"";
    echo "[VERSION] =\"${VERSION}\"";
    echo "==============================="
}

if [[ $1 = "--help" ]]; then help "Help info";fi;


echo "Checking parameters..."

# check mandatory parameters
if [ -z "$ARTIFACT_ID" ];then help "ARTIFACT_ID parameter is mandatory";fi
if [ -z "$VERSION" ];then help "VERSION parameter is mandatory";fi

# log parameters
logParams;

SPRINGBOOT_JAR=${APP_DIR}/${ARTIFACT_ID}-${VERSION}.jar

echo "Launching $SPRINGBOOT_JAR ..."

java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar $SPRINGBOOT_JAR;

