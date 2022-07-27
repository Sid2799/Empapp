FROM openjdk:11
EXPOSE 8080
ADD target/Empapp-0.0.1-SNAPSHOT.jar Empapp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Empapp-0.0.1-SNAPSHOT.jar"]  