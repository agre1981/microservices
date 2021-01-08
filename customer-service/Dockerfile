FROM openjdk:15
MAINTAINER Oleksandr Grechanov <agre1981@gmail.com>

ADD target/customer-service.jar customer-service.jar
ADD pom.xml pom.xml

HEALTHCHECK CMD curl --fail http://localhost:3333/actuator/info || exit 1

ENTRYPOINT ["java", "-jar", "/customer-service.jar"]

EXPOSE 3333
EXPOSE 5005