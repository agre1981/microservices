FROM openjdk
MAINTAINER Oleksandr Grechanov <agre1981@gmail.com>
ADD target/eureka-service.jar eureka-service.jar
HEALTHCHECK CMD curl --fail ${DISCOVERY_URL}/health || exit 1
ENTRYPOINT ["java", "-jar", "/eureka-service.jar"]
EXPOSE 8761
EXPOSE 5005