It is a sample Project of User and Product services 
where user service is a 1st project and it is called by a Product Service and Inter service communication through Feign Client.
Request goes to : 
Api GateWay -> EurekaServer -> UserService
Api GateWay -> EurekaServer -> UserService -> Product Service -> Config Server.

Run the services above order.
Eureka Server : http://localhost:8761
Api GateWay : http://localhost:9090
User Service : http://localhost:8085
Product Service : http://localhost:8086
Config Server : http://localhost:8888 ( get Properties from Github location)  

Replace the port number with Appi gateway port number (9090) in all places it will work.

 
       
