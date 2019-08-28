FROM openjdk:11
MAINTAINER Oleksandr Grechanov <agre1981@gmail.com>

ADD target/config-server.jar config-server.jar

HEALTHCHECK CMD curl --fail http://localhost:8888/actuator/info || exit 1

ENTRYPOINT ["java", "-jar", "/config-server.jar"]

EXPOSE 8888
EXPOSE 5005