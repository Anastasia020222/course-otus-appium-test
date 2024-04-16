#!/bin/bash

mvn clean test -Dbase.selenoid.url=$BASE_SELENOID_URL -DplatformName=$PLATFORM_NAME -DplatformVersion=$PLATFORM_VERSION