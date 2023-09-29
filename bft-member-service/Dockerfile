FROM openjdk:17-ea-11-jdk-slim
VOLUME /tmp
COPY build/libs/bft-member-service-1.0.jar BftMainService.jar
ENTRYPOINT ["java", "-jar", "BftMainService.jar"]