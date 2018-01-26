FROM openjdk
MAINTAINER Oleksandr Grechanov <agre1981@gmail.com>
ADD target/zipkin-service.jar zipkin-service.jar
ENTRYPOINT ["java", "-jar", "/zipkin-service.jar"]
EXPOSE 9411