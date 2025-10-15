FROM openjdk:21

LABEL "org.opencontainers.image.authors"="canse.com"

COPY target/gateway-server-0.0.1-SNAPSHOT.jar gateway-server-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","gateway-server-0.0.1-SNAPSHOT.jar"]