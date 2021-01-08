FROM openjdk:15
MAINTAINER Oleksandr Grechanov <agre1981@gmail.com>

ADD target/gateway-service.jar gateway-service.jar

HEALTHCHECK CMD curl --fail http://localhost:8765/actuator/info || exit 1

ENTRYPOINT ["java", "-jar", "/gateway-service.jar"]

EXPOSE 8765
EXPOSE 5005