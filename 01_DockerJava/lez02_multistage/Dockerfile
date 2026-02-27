# Stage 1: Build (creazione del JAR)
FROM maven:3.9.12-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn -q -Dskiptests package

# Stage 2: Runtime (copia il JAR ed eseguilo)
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/*.jar export.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "export.jar"]