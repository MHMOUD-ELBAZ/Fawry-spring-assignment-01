# 1. Use an official JDK runtime as base image
FROM eclipse-temurin:24-jre-alpine

# 2. Set a working directory inside the container
WORKDIR /app

RUN ls -R /app

# 3. Copy the JAR file into the container
COPY target/spring-assignment-01.jar app.jar

# 4. Expose port (Spring Boot default is 8080)
EXPOSE 8080

# 5. Run the JAR when container starts
ENTRYPOINT ["java", "-jar", "app.jar"]