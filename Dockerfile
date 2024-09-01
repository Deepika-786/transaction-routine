FROM openjdk:17-jdk-slim
LABEL maintainer="deepikachaudhary.577@gmail.com"
WORKDIR /app
COPY target/transaction-0.0.1-SNAPSHOT.jar /app/transaction.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "transaction.jar"]