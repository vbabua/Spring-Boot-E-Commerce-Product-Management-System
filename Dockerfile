FROM openjdk:16
ADD build/libs/springboot-products-apps.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]