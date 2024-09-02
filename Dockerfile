# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the host machine to the container
COPY /target/CodeSoftBackend-0.0.1-SNAPSHOT.jar.original /app/app.jar

# Expose the port that your Spring Boot app runs on
EXPOSE 8080

# Set the command to run the JAR file
CMD ["java", "-jar", "/app/app.jar"]
