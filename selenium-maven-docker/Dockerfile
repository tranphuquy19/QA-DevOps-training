FROM ubuntu:20.04

ENV DEBIAN_FRONTEND=noninteractive

ENV WORKING_DIR=/opt/enclave
ENV CHROME_PATH=/opt/chrome/chrome
ENV CHROME_DRIVER_PATH=/opt/chromedriver

# Ref: https://googlechromelabs.github.io/chrome-for-testing/#stable
ARG CHROME_URL=https://edgedl.me.gvt1.com/edgedl/chrome/chrome-for-testing/117.0.5938.149/linux64/chrome-linux64.zip
ARG CHROME_DRIVER_URL=https://edgedl.me.gvt1.com/edgedl/chrome/chrome-for-testing/117.0.5938.149/linux64/chromedriver-linux64.zip

# Install openjdk 11 and maven
RUN apt-get update && apt-get install -y openjdk-11-jdk maven wget unzip

# Install chrome and chromedriver
RUN wget -q -O chrome-linux64.zip $CHROME_URL && \
    unzip chrome-linux64.zip && \
    mv chrome-linux64 /opt/chrome && \
    rm chrome-linux64.zip && \
    wget -q -O chromedriver_linux64.zip $CHROME_DRIVER_URL && \
    unzip chromedriver_linux64.zip && \
    mv  chromedriver-linux64/chromedriver /opt/chromedriver && \
    rm chromedriver_linux64.zip

# Set the working directory
WORKDIR $WORKING_DIR

# Copy the source code
COPY . $WORKING_DIR
COPY .docker.env $WORKING_DIR/.env

# Run ./bin/test.sh
ENTRYPOINT ["bash", "./bin/test.sh"]
