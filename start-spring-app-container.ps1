# Ustaw ścieżkę do katalogu z plikiem docker-compose.yml
#$projectPath = "C:\ścieżka\do\twego\projektu"
#
## Przejdź do katalogu projektu
#Set-Location -Path $projectPath

mvn clean install


# Zbuduj i uruchom kontenery zdefiniowane w docker-compose.yml
docker-compose up --build -d

# Wyświetl logi z usługi spring-app, aby upewnić się, że uruchomiła się poprawnie
docker-compose logs spring-app
