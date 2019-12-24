FROM tomcat:9-jdk8
COPY target/java_stc_20-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/java_stc_20-1.0-SNAPSHOT.war
EXPOSE 8080
