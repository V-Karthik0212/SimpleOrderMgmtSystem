FROM eclipse-temurin:17-jre
WORKDIR /orders
COPY target/SimpleOrderMgmtSystem.jar SimpleOrderMgmtSystem.jar
EXPOSE 8080
ENTRYPOINT ["java","--add-opens","java.base/java.lang=ALL-UNNAMED","-jar","SimpleOrderMgmtSystem.jar"]

