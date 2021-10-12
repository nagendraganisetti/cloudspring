FROM openjdk:8

EXPOSE 8091

ADD target/studentService-0.0.1-SNAPSHOT.jar studentService-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","studentService-0.0.1-SNAPSHOT.jar"]