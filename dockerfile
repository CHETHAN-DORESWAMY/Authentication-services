FROM openjdk:23-jdk
COPY ./target/SecurityServices-0.0.1-SNAPSHOT.jar authentication-service.jar
CMD ["java","-jar","authentication-service.jar"]