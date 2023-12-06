# Użyj oficjalnego obrazu OpenJDK 17 jako bazy
FROM eclipse-temurin:17-jdk-alpine

VOLUME /tmp

# Ustaw katalog roboczy na /app
#WORKDIR /app

# Skopiuj plik JAR twojej aplikacji do kontenera
#COPY target/*.jar app.jar

# Skonfiguruj zmienne środowiskowe
#ENV SPRING_PROFILES_ACTIVE=production
ENV DATABASE_URL=jdbc:postgresql://localhost:5432/postgres

EXPOSE 8080

# Uruchom aplikację Spring Boot
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]