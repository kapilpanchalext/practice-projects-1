FROM openjdk:8-jdk-alpine as build
WORKDIR /app
COPY /spring-docker-1/.mvn/ .mvn
COPY /spring-docker-1/mvnw /spring-docker-1/pom.xml ./
RUN ./mvnw dependency:resolve
COPY /spring-docker-1/src ./src
CMD ["./mvnw", "spring-boot:run"]