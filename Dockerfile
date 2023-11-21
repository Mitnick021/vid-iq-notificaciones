FROM gradle:7.2.0-jdk17 AS builder
WORKDIR /app
COPY . .
RUN gradle clean build --no-daemon

FROM openjdk:17-jre-slim
WORKDIR /app
COPY --from=builder /app/build/libs/APP-0.0.1-SNAPSHOT.jar APP.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "APP.jar"]

