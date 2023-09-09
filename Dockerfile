FROM openjdk:17-alpine

#VOLUME /tmp
ARG VER=1.0
ARG JAR_FILE=target/spring-rest-pipeline.jar

ADD ${JAR_FILE} spring-rest-pipeline.jar
ENTRYPOINT ["java","-jar","/spring-rest-pipeline.jar"]

EXPOSE 8086