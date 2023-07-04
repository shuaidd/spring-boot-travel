FROM java:8
MAINTAINER shinyway
ADD target/lib /app/lib
ADD target/web.jar /app/web.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","-Dloader.home=/app","-Dloader.path=lib/","/app/web.jar"]
