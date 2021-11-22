FROM openjdk:8-jdk-alpine
MAINTAINER KUEBIKO
COPY target/notification-0.0.1-SNAPSHOT.jar notification-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/notification-0.0.1-SNAPSHOT.jar"]