# Multi-Stage Build Pattern: собираем Jar внутри контейнера, чтобы итоговый образ был лёгким
FROM maven:3.8.6-eclipse-temurin-17 AS builder
WORKDIR /build
COPY pom.xml .
COPY src src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=builder /build/target/demo-0.0.1-SNAPSHOT.jar app.jar
COPY wait-for-it.sh .
RUN sed -i 's/\r$//' wait-for-it.sh \
 && chmod +x wait-for-it.sh

ENTRYPOINT ["sh","-c","\
  ./wait-for-it.sh config-server:8888 --timeout=30 && \
  ./wait-for-it.sh db:5432          --timeout=30 && \
  java -jar app.jar \
"]
