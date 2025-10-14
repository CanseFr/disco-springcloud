services:
  mysqldb :
    image: mysql
    container_name: mysqldb
    ports:
      - "3300:3306"
    healthcheck:
      test: [ "CMD", "mysqladmin" ,"ping", "-h", "localhost" ]
    environment:
     MYSQL_ROOT_PASSWORD: root
     MYSQL_DATABASE: test

  departments-ms:
    build: ./department-microservice
    container_name: departments-ms
    ports:
      - "8080:8080"
    environment:
      SPRING_DATASOURCE_URL: "jdbc:mysql://mysqldb:3306/test"
      SPRING_DATASOURCE_USERNAME: root
      SPRING_DATASOURCE_PASSWORD: root
    depends_on:
      mysqldb :
        condition: service_healthy