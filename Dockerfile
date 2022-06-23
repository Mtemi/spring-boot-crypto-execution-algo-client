FROM openjdk:17-jdk-alpine
EXPOSE 9080
ARG JAR_FILE=target/spring-boot-crypto-execution-algo-client-1.0.war
ADD ${JAR_FILE} execution-algo-client.war
ENTRYPOINT ["java","-jar","execution-algo-client.war","--algo.base-domain=liquidalpha.mywire.org:9080"]