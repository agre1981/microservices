# Creating microservice using Spring Cloud

## 1. Run Eureka service
````
mvn spring-boot:run -f eureka-service/pom.xml 
````
Open in browser: http://localhost:8761 

## 1. Run Config service
````
mvn spring-boot:run -f config-server/pom.xml 
````
Open in browser: http://localhost:8888/account-service.yml 

## 2. Run Account service
````
mvn spring-boot:run -f account-service/pom.xml 
````
Open in browser: http://localhost:2222/accounts 

## 3. Run Customer service
````
mvn spring-boot:run -f customer-service/pom.xml 
````
Open in browser: http://localhost:3333/customers 

## 4. Run Gateway service
````
mvn spring-boot:run -f gateway-service/pom.xml 
````
Check redirection in browser: 

http://localhost:8765/api/account/accounts

http://localhost:8765/api/customer/customers

## 5. Run Zipkin service
````
mvn spring-boot:run -f zipkin-service/pom.xml 
````
Open in browser: http://localhost:9411

