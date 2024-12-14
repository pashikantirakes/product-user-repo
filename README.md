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

Testing in Postman :
1.User Serivce Request for saving user :
POST : http://localhost:8085/user/save
{
 "id":3,
 "name":"john",
 "age":51
}
GET :
Get Request By ID
http://localhost:8085/user/{id}

Get Request By Name
 http://localhost:8085/user/{name}
 All Users List : http://localhost:8085/user/

 2.Product Service Request for saving product
 POST : http://localhost:8086/product/save
   {
    "id":2,
    "productName":"Tractor",
    "userName":"akhil",
    "cost":500000
}
Product Response:
{
    "id": 2,
    "productName": "Tractor",
    "username": "akhil",
    "cost": 500000,
    "age": 18
}
GET : http://localhost:8086/product/Tractor

Replace the port number with Appi gateway port number (9090) in all places it will work.

 
       
