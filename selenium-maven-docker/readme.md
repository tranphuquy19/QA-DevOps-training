# Selenium Maven Docker

This repository provides a set of instructions for building and running a web application using Selenium, Maven, and Docker.

## 1. Build the web-app

Use the following command to build the web application Docker image:

```bash
docker-compose build web-app
```

## 2. Run the web-app

To start the web application in a Docker container, use the following command:

```bash
docker-compose --profile default -f docker-compose.yml up -d  
```

## 3. Open the web-app

Open [http://localhost:3000](http://localhost:3000) in your web browser to access the running web application.

## 4. Run Selenium Test

### 4.1 Run Selenium Test with Docker-compose 

To run the Selenium tests using Docker-compose, use the following command:

```bash
docker-compose --profile test -f docker-compose.yml up
```

### 4.2 Build & Run Selenium Test with Docker-compose (with debug)

To build and run the Selenium tests with Docker-compose and enable debugging, use the following command:

```bash
docker-compose --profile test -f docker-compose.yml up --build
```

### 4.3 Run Selenium Test in individual container

To run the Selenium tests in an individual container, use the following command:

```bash
docker run --rm -it --network=selenium-maven-docker_enclave -v $(pwd)/test-output:/opt/enclave/test-output --name selenium-test selenium-mvn-docker:latest
```

### 4.4 Run Selenium Test in individual container (allow debugging)

To run the Selenium tests in an individual container that allows debugging, use the following command:

```bash
docker run --rm -it --network=selenium-maven-docker_enclave -v $(pwd)/test-output:/opt/enclave/test-output --name selenium-test selenium-mvn-docker:latest /bin/bash
```

## 5. Run the web-app at local

To run the web application locally, follow these steps:

1. Navigate to the 'postman-api-testing' directory.
2. Install the required dependencies by running the command: `npm install`.
3. Start the web application using the command: `npm run start`.

## 6. Run Selenium Test at local

To run the Selenium tests locally, follow these steps:

1. Execute the command: `bash ./bin/test.sh`.
2. Note that you must have Chrome and the appropriate version of Chromedriver installed on your local machine.

Description: This project provides a complete setup for running a web application using Selenium, Maven, and Docker. It includes instructions for building the web app, running it in a Docker container, and executing Selenium tests. Additionally, there are guidelines for running the web app and Selenium tests locally for development and debugging purposes. Please ensure that you have the necessary dependencies installed, such as Chrome and Chromedriver, before running the tests. By following these instructions, you'll be able to seamlessly build, run, and test your web application using a combination of Selenium, Maven, and Docker.