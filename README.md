# SpringBootApplicationAccount
Idexcel Coding Assignment

Steps to Start Application and Run PostMan Test

1.Go to IdexcelRestApplication Class -> Right click -> Run as Java Application
2. This will start the Tomcat Server and can perform REST API actions using PostMan . The same data gets refelected in h2- console.
3. I have performed Junit Tests in SpringBootTest folder and all are running Successfully
4. To check output from PostMan using the following guidelines as mentioned below:
	a) Open Ppostman console and provide the url : http://localhost:8080/account. Perform all type of REST operations such as GET,POST,PUT and DELETE.
	
Note: I have attached PostMan REST API calls output as Screenshots in the repository

To check Swagger API documentation -> Go to application.properties file(src/main/resources) 
in the SpringBoot project and uncomment the following line: server.servlet.context-path=/api -> To enable servlet context path for swagger API


 
