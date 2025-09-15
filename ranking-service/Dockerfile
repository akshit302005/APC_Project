# Use OpenJDK 17 (or your project JDK version)
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven project files
COPY pom.xml .
COPY src ./src

# Package the application
RUN apt-get update && apt-get install -y maven && mvn clean package -DskipTests

# Run the Spring Boot jar
CMD ["java", "-jar", "target/ranking-service-0.0.1-SNAPSHOT.jar"]
