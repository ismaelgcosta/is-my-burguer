FROM eclipse-temurin:20-jdk
VOLUME /tmp

COPY ./api-main-build/target/is-my-burger-app.jar is-my-burger-app.jar
CMD ls ./

EXPOSE 8080
EXPOSE 8088

ENTRYPOINT ["java","-jar","/is-my-burger-app.jar","--server.port=8080"]