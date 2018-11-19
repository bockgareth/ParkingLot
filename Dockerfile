FROM tomcat:8.5.35-jre8-alpine

MAINTAINER Gareth Bock "bockgareth@gmail.com"

EXPOSE 8080

RUN rm -rf /usr/local/tomcat/webapps/*

COPY ./target/ParkingLot-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

CMD ["catalina.sh", "run"]