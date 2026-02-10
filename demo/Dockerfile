FROM gradle:9.3.0-jdk17 AS builder

WORKDIR /home/gradle/src
COPY . .

RUN gradle clean bootJar --no-daemon


FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=builder /home/gradle/src/build/libs/*.jar app.jar

EXPOSE 8080