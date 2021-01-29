# For Java 8, try this
FROM openjdk:8-jdk-alpine

# Refer to Maven build -> finalName
COPY ./target/app-0.0.1.jar /usr/app/

# cd /usr/app
WORKDIR /usr/app

ENTRYPOINT ["java","-jar","app-0.0.1.jar"]