FROM openjdk:17
RUN mkdir /storageApp
WORKDIR /storageApp
COPY rest/target/StorageApplication.jar /storageApp
CMD ["java","-jar","/storageApp/StorageApplication.jar"]
EXPOSE 8081