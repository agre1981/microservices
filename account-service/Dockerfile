FROM openjdk
MAINTAINER Oleksandr Grechanov <agre1981@gmail.com>
ADD target/account-service.jar account-service.jar
HEALTHCHECK CMD curl --fail ${ACCOUNT_URL}/health || exit 1
# add for debug "-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5005"
ENTRYPOINT ["java", "-jar", "/account-service.jar"]
EXPOSE 2222
EXPOSE 5005