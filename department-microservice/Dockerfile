FROM openjdk:21

LABEL "org.opencontainers.image.authors"="canse.com"

COPY target/department-microservice-0.0.1-SNAPSHOT.jar department-microservice-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","department-microservice-0.0.1-SNAPSHOT.jar"]