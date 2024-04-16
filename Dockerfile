FROM openjdk:21-oracle
WORKDIR /app
COPY target/Students-0.0.1-SNAPSHOT.jar Students.jar
CMD ["java", "-jar", "Students.jar"]