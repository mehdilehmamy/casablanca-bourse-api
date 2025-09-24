# ---- Build stage ----
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /src
COPY . .
RUN mvn -DskipTests package

# ---- Runtime stage ----
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /src/target/*.jar app.jar
ENV PORT=8080
EXPOSE 8080
# ⬇️ bind to all interfaces and Render's dynamic port
CMD ["sh","-c","java -Dserver.address=0.0.0.0 -Dserver.port=${PORT} -jar app.jar"]
