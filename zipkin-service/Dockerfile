FROM openjdk
MAINTAINER Oleksandr Grechanov <agre1981@gmail.com>
ADD target/zipkin-service.jar zipkin-service.jar
HEALTHCHECK CMD curl --fail ${ZIPKIN_URL}/health || exit 1
ENTRYPOINT ["java", "-jar", "/zipkin-service.jar"]
EXPOSE 9411
EXPOSE 5005