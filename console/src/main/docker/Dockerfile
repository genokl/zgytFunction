FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD console-0.0.1-SNAPSHOT.jar /console.jar
ENV profile="mysql"
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/console.jar"]