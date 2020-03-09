FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.war

#cd /usr/local/workspace
WORKDIR /usr/local/workspace

COPY ${JAR_FILE} app.jar

# java -jar /usr/local/workspace/app.jar
ENTRYPOINT ["java","-jar","app.jar"]