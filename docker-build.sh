chmod +x ./mvnw  
./mvnw install -U
docker compose build
docker compose up