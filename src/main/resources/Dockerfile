FROM maven:3.8.5-openjdk-17 as build
copy . .
run mvn clean package -DskipTest

from openjdk:22.0.1-jdk-slim
copy --from=build /target/tienda-1.jar tienda.jar
expose 80
entrypoint ["java","-jar","tienda.jar"]