FROM openjdk:11
ADD target/earthquake-backend-0.0.1-SNAPSHOT.jar earthquake-backend.jar
ENTRYPOINT ["java", "-jar", "earthquake-backend.jar"]
