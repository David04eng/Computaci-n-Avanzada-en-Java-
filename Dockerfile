# Etapa 1: Construcción (Build)
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copiar el archivo pom.xml y descargar dependencias (esto optimiza la caché de Docker)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar el código fuente y compilar el proyecto
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución (Runtime)
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# Crear un usuario no root por seguridad
RUN addgroup --system spring && adduser --system spring --ingroup spring
USER spring:spring

# Copiar el JAR generado desde la etapa de construcción
# El nombre del jar suele ser artifactId-version.jar basado en tu pom.xml
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto por defecto de Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]

