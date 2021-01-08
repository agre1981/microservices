FROM openjdk:15
MAINTAINER Oleksandr Grechanov <agre1981@gmail.com>

ADD target/eureka-service.jar eureka-service.jar

HEALTHCHECK CMD curl --fail http://localhost:8761/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "/eureka-service.jar"]
EXPOSE 8761
EXPOSE 5005