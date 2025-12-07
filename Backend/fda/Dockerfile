# Use Java 21 JDK base image (because your logs show Java 21)
FROM eclipse-temurin:21-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the jar from target folder into the image
COPY target/*.jar app.jar

# Expose the port your Spring Boot app uses (default 8080)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
