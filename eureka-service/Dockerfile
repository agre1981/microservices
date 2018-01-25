FROM openjdk
MAINTAINER Oleksandr Grechanov <agre1981@gmail.com>
ADD target/eureka-service.jar eureka-service.jar
ENTRYPOINT ["java", "-jar", "/eureka-service.jar"]
EXPOSE 8761