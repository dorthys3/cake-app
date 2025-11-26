# 1. Build stage
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# 3. Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# 4. Copy source code and build the application
COPY src ./src
RUN mvn clean package -DskipTests


# 5. Run stage
FROM eclipse-temurin:17-jre

WORKDIR /app

# 7. Copy the built JAR file
COPY --from=build /app/target/Cake-0.0.1-SNAPSHOT.jar Cake-0.0.1-SNAPSHOT.jar

# 8. Expose port
EXPOSE 8082

# 9. Run the app
ENTRYPOINT ["java", "-jar", "Cake-0.0.1-SNAPSHOT.jar"]
