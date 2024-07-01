
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

# syntax=docker/dockerfile:1

# syntax=docker/dockerfile:1

# Usa una versión de Maven y JDK que esté disponible
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app

# Copiar el proyecto y construirlo
COPY . /app
RUN mvn clean install -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/gestion-pagos-0.0.1-SNAPSHOT.jar /app/gestion-pagos.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "gestion-pagos.jar"]
