FROM ubuntu:20.04

ENV DEBIAN_FRONTEND=noninteractive

ENV LC_ALL=C
ENV DISPLAY=:99
#ENV SCREEN_GEOMETRY=1920x1080x16

ENV WORKING_DIR=/opt/enclave
ENV CHROME_PATH=/opt/chrome/chrome
ENV CHROME_DRIVER_PATH=/opt/chromedriver

# Ref: https://googlechromelabs.github.io/chrome-for-testing/#stable
ARG CHROME_VERSION=117.0.5938.149
ARG CHROME_URL=https://edgedl.me.gvt1.com/edgedl/chrome/chrome-for-testing/$CHROME_VERSION/linux64/chrome-linux64.zip
ARG CHROME_DRIVER_URL=https://edgedl.me.gvt1.com/edgedl/chrome/chrome-for-testing/$CHROME_VERSION/linux64/chromedriver-linux64.zip

# Install openjdk 11 and maven and other dependencies
RUN apt-get update && apt-get install -y openjdk-11-jdk maven wget unzip \
    ca-certificates fonts-liberation libappindicator3-1 libasound2 libatk-bridge2.0-0 libatk1.0-0 libc6 \
    libcairo2 libcups2 libdbus-1-3 libexpat1 libfontconfig1 libgbm1 libgcc1 libglib2.0-0 libgtk-3-0 libnspr4 \
    libnss3 libpango-1.0-0 libpangocairo-1.0-0 libstdc++6 libx11-6 libx11-xcb1 libxcb1 libxcomposite1 libxcursor1 \
    libxdamage1 libxext6 libxfixes3 libxi6 libxrandr2 libxrender1 libxss1 libxtst6 lsb-release xdg-utils

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
CMD ["bash", "./bin/test.sh"]
