# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.5/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.5/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#web)
* [Spring for Apache Kafka](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#messaging.kafka)

### Guides
* Start up Kafka infrastructure `docker compose -f docker-compose.yml up -d`
* Start this application in your favourite IDE (or build and run as a regular jar file)
* Issue GET request to `http://localhost:8082/kafka-producer/send` and verify messages are sent to both topics
* Issue GET request to `http://localhost:8082/kafka-producer/stop` to stop Kafka listener container, observe logs
* Shut down the application
* Shut down Kafka infrastructure `docker compose down`
