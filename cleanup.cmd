@ECHO OFF
docker stop is-my-burger-api
docker stop postgres-ismyburguer
docker stop mongodb-ismyburguer
docker rm is-my-burger-api
docker rm postgres-ismyburguer
docker rm mongodb-ismyburguer
docker images prune
docker volume rm is-my-burguer_mongodb-ismyburguer
docker volume rm is-my-burguer_postgres-ismyburguer