# syntax=docker/dockerfile:1

FROM openjdk:21-jdk

ENV SERVER_PORT=8081
ENV SPRING_KAFKA_BOOTSTRAP_SERVERS=microview-kafka-1:29092
ENV SERVICEA_URL=microview-v3-msa-1:8088

COPY opentelemetry-javaagent.jar javaagent.jar
COPY target/MicroServiceB-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-javaagent:/javaagent.jar","-Dotel.exporter.otlp.protocol=grpc","-Dotel.metrics.exporter=prometheus","-Dotel.exporter.prometheus.port=9090","-Dotel.logs.exporter=otlp","-Dotel.exporter.otlp.logs.endpoint=http://otel-collector-service:4317","-Dotel.exporter.otlp.traces.endpoint=http://tempo-service:4317","-jar","/app.jar"]
#ENTRYPOINT ["java","-javaagent:/javaagent.jar","-Dotel.exporter.otlp.protocol=grpc","-Dotel.metrics.exporter=prometheus","-Dotel.exporter.prometheus.port=9090","-Dotel.logs.exporter=otlp","-Dotel.exporter.otlp.logs.endpoint=http://collector:4317","-Dotel.exporter.otlp.traces.endpoint=http://tempo:4317","-jar","/app.jar"]