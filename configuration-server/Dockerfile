FROM openjdk:21

LABEL "org.opencontainers.image.authors"="canse.com"

COPY target/configuration-server-0.0.1-SNAPSHOT.jar configuration-server-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","configuration-server-0.0.1-SNAPSHOT.jar"]