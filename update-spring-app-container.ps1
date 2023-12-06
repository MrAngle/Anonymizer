## Ustaw ścieżkę do katalogu z plikiem docker-compose.yml
#$projectPath = ""
#
## Przejdź do katalogu projektu
#Set-Location -Path $projectPath
mvn clean install

# Zbuduj na nowo obraz aplikacji Spring Boot
docker-compose build spring-app --no-cache

# Uruchom ponownie usługę spring-app, upewniając się, że nie restartuje zależności
docker-compose up --no-deps spring-app

# Wyświetl logi z usługi spring-app, aby upewnić się, że uruchomiła się poprawnie
#docker-compose logs spring-app
