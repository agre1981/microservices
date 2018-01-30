FROM openjdk
MAINTAINER Oleksandr Grechanov <agre1981@gmail.com>
ADD target/customer-service.jar customer-service.jar
HEALTHCHECK CMD curl --fail ${CUSTOMER_URL}/health || exit 1
ENTRYPOINT ["java", "-jar", "/customer-service.jar"]
EXPOSE 3333
EXPOSE 5005