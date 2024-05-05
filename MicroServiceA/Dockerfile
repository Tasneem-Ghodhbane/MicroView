# syntax=docker/dockerfile:1

FROM openjdk:21-jdk

ENV SERVER_PORT=8088
ENV SPRING_KAFKA_BOOTSTRAP_SERVERS=microview-kafka-1:29092
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://pfe-postgres-1:5432/microview_db
ENV SPRING_DATASOURCE_USERNAME=test
ENV SPRING_DATASOURCE_PASSWORD=test

COPY target/MicroServiceA-0.0.1-SNAPSHOT.jar app.jar
COPY opentelemetry-javaagent.jar javaagent.jar
ENTRYPOINT ["java","-javaagent:/javaagent.jar","-Dotel.exporter.otlp.protocol=grpc","-Dotel.metrics.exporter=prometheus","-Dotel.exporter.prometheus.port=9090","-Dotel.logs.exporter=otlp","-Dotel.exporter.otlp.logs.endpoint=http://otel-collector-service:4317","-Dotel.exporter.otlp.traces.endpoint=http://tempo-service:4317","-jar","/app.jar"]