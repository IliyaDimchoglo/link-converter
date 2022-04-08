FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ciklum.jar
ENTRYPOINT ["java","-jar","/ciklum.jar"]
EXPOSE 8080
