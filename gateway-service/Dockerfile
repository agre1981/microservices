FROM openjdk
MAINTAINER Oleksandr Grechanov <agre1981@gmail.com>
ADD target/gateway-service.jar gateway-service.jar
ENTRYPOINT ["java", "-jar", "/gateway-service.jar"]
EXPOSE 8765