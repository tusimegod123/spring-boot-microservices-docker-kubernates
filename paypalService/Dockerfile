FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} pay-pal-service.jar
ENTRYPOINT ["java","-jar","/pay-pal-service.jar"]
EXPOSE 8005