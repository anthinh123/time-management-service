FROM eclipse-temurin:21

LABEL maintainer="thinh@gmail.com"

WORKDIR /app

COPY ./time-management-service/build/libs/timemanagementservice-0.0.1-SNAPSHOT.jar /app/workdayservice.jar

ENTRYPOINT ["java", "-jar", "workdayservice.jar"]