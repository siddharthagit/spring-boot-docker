# Spring Boot Java Web Application
This is a simple Spring Boot Java Web Application which fetch links from a specified URL.
It has docker support.
It uses the following technologies
1. Java 10
2. Spring Boot 1.5.9
3. Maven
4. Docker
 
## Running the Application


#### Build the App
mvn install

#### Build docker image
docker image build .

#### Execute the docker image
docker run -p 8080:8080  IMAGE_ID

