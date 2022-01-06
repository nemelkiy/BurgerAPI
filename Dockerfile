FROM openjdk:8-jdk-alpine
COPY ./target/burgerapi-1.0.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "burgerapi-1.0.jar"]