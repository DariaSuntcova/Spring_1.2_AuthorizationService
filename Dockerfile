FROM openjdk:17-jdk-slim-buster

EXPOSE 8080

COPY target/SpringBootRESTauthorizationService-0.0.1-SNAPSHOT.jar authorizationService.jar

CMD ["java", "-jar", "authorizationService.jar"]



