FROM openjdk:21

LABEL "org.opencontainers.image.authors"="canse.com"

COPY target/eureka-server-0.0.1-SNAPSHOT.jar eureka-server-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","eureka-server-0.0.1-SNAPSHOT.jar"]