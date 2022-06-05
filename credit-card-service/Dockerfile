FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} credit-card-service.jar
ENTRYPOINT ["java","-jar","/credit-card-service.jar"]
EXPOSE 8002