#### 1 Create a Rest Controller with a simple mapping "api" and getmapping "/"
#### 2 Check if it works
#### 3 Create an entity Product, put all methods and setters with getters
#### 4 Put annotation, entity, id, generate strategy
#### 5 Create an interface reposity from JpaRepositry (dao)
#### 6 Create an interface service with annotations
#### 7 Create an implementation of this service with annotations and DI
#### 8 Import a service into the controller and DI, let "/" return all products 





## How to kill the port listener
#### netstat -ano | findstr :8080
TCP    0.0.0.0:8080           0.0.0.0:0              LISTENING       10320
TCP    [::]:8080              [::]:0                 LISTENING       10320

taskkill /F /PID 10320
SUCCESS: The process with PID 10320 has been terminated.