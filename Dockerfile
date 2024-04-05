#FROM maven:3-eclipse-temurin-17 AS build
#COPY . .
#RUN mvn clean package -Pprod -DskipTests
#FROM openjdk:11-jdk-slim   FROM maven:3-eclipse-temurin-17 AS build

FROM maven:17-jdk-11 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests
FROM openjdk:11-jdk-slim
COPY --from=build /target/DogsManagementSystem-0.0.1-SNAPSHOT.jar DogsManagementSystem.jar
CMD ["java", "-jar", "DogsManagementSystem.jar"]