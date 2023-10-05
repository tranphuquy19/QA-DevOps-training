# Selenium Maven Docker

## 1. Build Selenium Maven Docker Image

```bash
docker-compose build selenium
```

## 2. Run WordPress

```bash
docker-compose --profile default -f docker-compose.yml up -d  
```

## 3. Open WordPress

Open [http://localhost:8000](http://localhost:8000) in your browser. And install WordPress.

## 4. Run Selenium Test

### 4.1 Run Selenium Test with Docker-compose 
```bash
docker-compose --profile test -f docker-compose.yml up
```

### 4.2 Build & Run Selenium Test with Docker-compose (with debug)
```bash
docker-compose --profile test -f docker-compose.yml up --build
```

### 4.3 Run Selenium Test in individual container
```bash
docker run --rm -it --network=selenium-maven-docker_enclave -v $(pwd)/test-output:/opt/enclave/test-output --name selenium-test selenium-mvn-docker:latest
```

### 4.4 Run Selenium Test in individual container (with debug)
```bash
docker run --rm -it --network=selenium-maven-docker_enclave -v $(pwd)/test-output:/opt/enclave/test-output --name selenium-test selenium-mvn-docker:latest /bin/bash
```

## 5. Stop WordPress

```bash
docker-compose --profile default -f docker-compose.yml down --volumes
```
