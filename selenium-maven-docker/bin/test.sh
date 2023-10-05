#!/bin/bash

# Export the environment variables from the .env file
# shellcheck disable=SC2046
# shellcheck disable=SC2196
export $(egrep -v '^#' .env | xargs)

echo "Running the test for the $ENV environment"

# Run the Testng test
mvn clean test -Dsurefire.suiteXmlFile=./testng.xml 2>&1 | tee testng.log
