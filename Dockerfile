FROM openjdk:15-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} Project-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/Project-0.0.1-SNAPSHOT.jar"]