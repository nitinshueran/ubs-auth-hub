FROM openjdk:8-jdk-alpine
ADD target/ubs-user-service-0.0.1-SNAPSHOT.jar ubs-user-service-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ubs-user-service-0.0.1-SNAPSHOT.jar"]