# Creating microservice using Spring Cloud

## 1. Run Eureka service
````
mvn spring-boot:run -f eureka-service/pom.xml 
````
Open in browser: http://localhost:8761 

## 2. Run Config service
````
mvn spring-boot:run -f config-server/pom.xml 
````
Open in browser: http://localhost:8888/account-service.yml 

## 3. Run Account service
````
mvn spring-boot:run -f account-service/pom.xml 
````
Open in browser: http://localhost:2222/accounts 

## 4. Run Customer service
````
mvn spring-boot:run -f customer-service/pom.xml 
````
Open in browser: http://localhost:3333/customers 

## 5. Run Gateway service
````
mvn spring-boot:run -f gateway-service/pom.xml 
````
Check redirection in browser: 

http://localhost:8765/api/account/accounts

http://localhost:8765/api/customer/customers

## 6. Docker
Start containers:
````
docker-compose up -d
docker-compose up -d --build elasticsearch kibana zipkin 
docker-compose up -d --build eureka config 
docker-compose up -d --build account customer gateway 
````

Health check:
````
docker inspect --format "{{json .Name}} {{json .State.Health.Status}}" microservices_eureka_1 microservices_config_1 microservices_account_1 microservices_customer_1 microservices_gateway_1 

docker inspect --format "{{json .Name}} {{json .State.Status}}" microservices_elasticsearch_1 microservices_kibana_1 microservices_zipkin_1
````

Run command inside docker:
````
docker exec -i -t microservices_config_1 curl http://config:8888/actuator/health
````

## 7. Logs:
- Elasticsearch: http://localhost:5601
- Kibana: http://localhost:5601
- Zipkin: http://localhost:9411

## 7. Swagger
Open swagger account json/html:
````
http://localhost:2222/v2/api-docs
http://localhost:2222/swagger-ui.html
````

Open swagger customer json/html:
````
http://localhost:3333/v2/api-docs
http://localhost:3333/swagger-ui.html
````
