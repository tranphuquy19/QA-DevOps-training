# Use the official newman image
FROM postman/newman:alpine

# Set the working directory to /app
WORKDIR /app

# Install newman-reporter-html
RUN npm install -g newman-reporter-html

# Copy the environment and collection JSON files to the container
COPY docker.environment.json collection.json ./

# Run the newman command with the environment and collection files
ENTRYPOINT ["newman", "run", "collection.json", "--environment", "docker.environment.json"]
