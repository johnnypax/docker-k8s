# Runtime-only image (più leggera). Il JAR lo produciamo già con Maven.
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copia il jar buildato da Maven
COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]