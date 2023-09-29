FROM openjdk:17-ea-11-jdk-slim
VOLUME /tmp
COPY build/libs/bft-discovery-service-1.0.jar BftDiscoveryService.jar
ENTRYPOINT ["java", "-jar", "BftDiscoveryService.jar"]