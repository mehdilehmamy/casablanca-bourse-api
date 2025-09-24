# ---- Build stage ----
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /src
COPY . .
# Force a Spring Boot fat JAR (repackage) and list artifacts for visibility
RUN mvn -DskipTests clean package spring-boot:repackage && ls -l target

# ---- Runtime stage ----
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /src/target/*.jar app.jar
ENV PORT=8080
EXPOSE 8080
# Bind to Render's port + all interfaces, and enable Spring Boot debug to see root cause
CMD ["sh","-c","java -Dserver.address=0.0.0.0 -Dserver.port=${PORT} -jar app.jar --debug"]
