FROM openjdk:11-jre-slim

RUN mkdir /app

WORKDIR /app

ADD target/collection-1.0-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "collection-1.0-SNAPSHOT.jar"]
