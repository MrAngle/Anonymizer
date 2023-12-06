# Ustawienia dla obrazu aplikacji
$imageName = "moja-aplikacja"
$imageTag = "v1.0"

# Ustawienia dla bazy danych
$dbHost = "localhost"
$dbPort = "5432" # Domyślny port dla PostgreSQL
$dbName = "postgres"
$dbUser = "postgres"
$dbPassword = "password"
$dumpPath = "C:\Users\User\Documents\Dumps"
$dumpFileName = "dump_${imageName}_${imageTag}.sql"

$env:PGPASSWORD = $dbPassword

# Wykonanie dumpu bazy danych
& "pg_dump" -h $dbHost -p $dbPort -U $dbUser -F c -b -v -f "$dumpPath\$dumpFileName" $dbName


#& "pg_dump" -h $dbHost -p $dbPort -U $dbUser -F c -b -v -f "$dumpPath\$dumpFileName" $dbName


# Budowanie aplikacji Spring Boot używając Mavena
#mvn clean package

# Budowanie obrazu Docker z aplikacją Spring Boot, ustawiając nazwę i tag
#docker build -t "$($imageName):$($imageTag)" .