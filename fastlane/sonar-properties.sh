#!/bin/bash

create_gradle_properties() {
  SONAR_TOKEN=$1
  GRADLE_PROPERTIES_LOCATION=~/.gradle/gradle.properties

  mkdir -p ~/.gradle

  rm -f $GRADLE_PROPERTIES_LOCATION

  printf "sonar.login=$SONAR_TOKEN\n" >> $GRADLE_PROPERTIES_LOCATION
}

create_gradle_properties $SONAR_TOKEN
