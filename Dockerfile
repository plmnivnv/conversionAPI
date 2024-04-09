FROM openjdk:17-jdk
ARG JAR_FILE=build/libs/*.jar
COPY build/libs/*.jar conversionAPI-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","/conversionAPI-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
