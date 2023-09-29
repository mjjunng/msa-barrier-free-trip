FROM openjdk:17-ea-11-jdk-slim
VOLUME /tmp
COPY build/libs/bft-apigateway-service-1.0.jar BftApigatewayService.jar
ENTRYPOINT ["java", "-jar", "BftApigatewayService.jar"]