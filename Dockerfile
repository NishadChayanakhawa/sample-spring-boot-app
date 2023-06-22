ARG JAVA_VERSION=17
FROM openjdk:${JAVA_VERSION}
COPY target/sample-spring-boot-app-1.0.0.jar sample-spring-boot-app.jar
EXPOSE 8999
CMD ["java","-jar","/sample-spring-boot-app.jar"]