# ---- Build stage (Java 8) ----
FROM maven:3.9-eclipse-temurin-8 AS build
WORKDIR /src
COPY . .
RUN mvn -DskipTests clean package spring-boot:repackage && ls -l target

# ---- Runtime stage (Java 8 JRE) ----
FROM eclipse-temurin:8-jre
WORKDIR /app
COPY --from=build /src/target/*.jar app.jar

ENV PORT=8080
EXPOSE 8080
CMD ["sh","-c","java -Dserver.address=0.0.0.0 -Dserver.port=${PORT} -jar app.jar --debug"]
