FROM openjdk:8-jdk-alpine
ADD target/ubs-auth-hub-0.0.1-SNAPSHOT.jar ubs-auth-hub-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "ubs-auth-hub-0.0.1-SNAPSHOT.jar"]