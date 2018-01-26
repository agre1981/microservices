FROM openjdk
MAINTAINER Oleksandr Grechanov <agre1981@gmail.com>
ADD target/config-server.jar config-server.jar
ENTRYPOINT ["java", "-jar", "/config-server.jar"]
EXPOSE 8888