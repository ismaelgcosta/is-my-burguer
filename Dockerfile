FROM maven:3.9.5-eclipse-temurin-21-alpine as build
#
WORKDIR /is-my-burguer
#
COPY ./ ./
RUN mvn install

ENV POSTGRES_USER="uri"
ENV POSTGRES_PASSWORD="uri"
ENV MONGO_PASSWORD="uri"
ENV MONGO_USERNAME="uri"
FROM eclipse-temurin:21-jdk-alpine as main
EXPOSE 8080
EXPOSE 8081
EXPOSE 5005

COPY --from=build /is-my-burguer/api-main-build/target/is-my-burger-app.jar is-my-burger-app.jar

ENTRYPOINT ["java","-jar","is-my-burger-app.jar","--server.port=8080","-Dspring.profiles.active=production"]
#CMD ["sleep","infinity"]