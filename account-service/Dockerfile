FROM openjdk:11
MAINTAINER Oleksandr Grechanov <agre1981@gmail.com>

ADD target/account-service.jar account-service.jar
ADD pom.xml pom.xml

HEALTHCHECK CMD curl --fail http://localhost:2222/actuator/info || exit 1

# add for debug "-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5005"
ENTRYPOINT ["java", "-jar", "/account-service.jar"]

EXPOSE 2222
EXPOSE 5005