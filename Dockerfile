FROM openjdk:11
MAINTAINER aidos.jantleu@gmail.com
COPY target/gateway-api-*.war gateway-api.jar
ENTRYPOINT ["java","-jar","/gateway-api.jar"]