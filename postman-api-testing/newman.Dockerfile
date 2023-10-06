# Use the official newman image
FROM postman/newman:alpine

# Set the working directory to /app
WORKDIR /app

# Install newman-reporter-html
RUN npm install -g newman-reporter-html

# Copy the environment and collection JSON files to the container
COPY environment.json collection.json ./

# Run the newman command with the environment and collection files
# CMD ["run", "collection.json", "--environment", "environment.json"]
