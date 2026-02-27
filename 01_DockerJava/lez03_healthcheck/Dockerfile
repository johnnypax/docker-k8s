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

# Installo CURL perché mi serve per HC
USER root
RUN apt-get update && \
	apt-get install curl -y
	
HEALTHCHECK --start-period=20s --timeout=3s --retries=3 --interval=10s
	CMD curl --fsS http://localhost:8080/health || exit 1

ENTRYPOINT ["java", "-jar", "export.jar"]