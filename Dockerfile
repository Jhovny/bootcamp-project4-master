FROM openjdk:12-jdk
COPY "./target/master-0.0.1-SNAPSHOT.jar" "master.jar"
ENTRYPOINT ["java","-jar","master.jar"]