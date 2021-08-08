FROM openjdk:11
MAINTAINER aidos.jantleu@gmail.com
COPY target/api-gateway-*.war api-gateway.jar
ENTRYPOINT ["java","-jar","/api-gateway.jar"]