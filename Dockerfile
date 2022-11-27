FROM openjdk:11
COPY "./target/rest-desafio-administra-persona-1.0.0-SNAPSHOT.jar" "servicio-desafio.jar"
ENTRYPOINT ["java", "-jar", "servicio-desafio.jar"]
