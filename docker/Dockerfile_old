FROM adoptopenjdk:14-jre-hotspot
ARG JAR_FILE=target/greenstone*.jar
COPY ${JAR_FILE} application.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/application.jar"]