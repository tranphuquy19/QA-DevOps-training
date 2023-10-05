#!/bin/bash

# Export the environment variables from the .env file
# shellcheck disable=SC2046
# shellcheck disable=SC2196
export $(egrep -v '^#' .env | xargs)

echo "Running the test for the $ENV environment"

function clean() {
    # Remove the test-output folder
    rm -rf test-output
}

# Clean the test-output folder
clean

# Run the Testng test
mvn clean test 2>&1 | tee testng.log

# Copy the testng report to the test-output folder
cp -r target/surefire-reports/ test-output/
