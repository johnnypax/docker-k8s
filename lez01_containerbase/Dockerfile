FROM eclipse-temurin:17-jre
WORKDIR /app
COPY /target/*.jar export.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "export.jar"]
