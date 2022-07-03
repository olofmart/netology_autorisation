FROM openjdk:11
EXPOSE 8080
ADD /target/autorisation-0.0.1-SNAPSHOT.jar autorisation.jar
ENTRYPOINT ["java", "-jar", "autorisation.jar"]