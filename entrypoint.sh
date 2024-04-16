#!/bin/bash

mvn clean test -Dremote.url=$REMOTE_URL -DplatformName=$PLATFORM_NAME -DplatformVersion=$PLATFORM_VERSION