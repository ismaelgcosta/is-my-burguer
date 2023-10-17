FROM eclipse-temurin
VOLUME /tmp

COPY ./api-main-build/target/is-my-burger-app.jar is-my-burger-app.jar
CMD ls ./

EXPOSE 8080

ENTRYPOINT ["java","-jar","/is-my-burger-app.jar"]