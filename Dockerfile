FROM eclipse-temurin:20-jdk
VOLUME /tmp

COPY ./api-main-build/target/is-my-burger-app.jar is-my-burger-app.jar
COPY script-inicial.sql /docker-entrypoint-initdb.d/init.sql
CMD ls ./

EXPOSE 8080

ENTRYPOINT ["java","-jar","/is-my-burger-app.jar"]