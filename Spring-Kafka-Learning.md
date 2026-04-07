# Spring Kafka Beginner Course

This guide covers basic Kafka operations using the command line. Ensure Kafka is running via Docker before proceeding.

## Accessing the Kafka Container

Enter the Kafka terminal from the command prompt:

```bash
docker exec -it kafka-spring-springcloud-kafka-1 bash
```

## Managing Topics

### Create a Topic
```bash
kafka-topics --create --topic my-topic --bootstrap-server localhost:9092 --partitions 3 --replication-factor 1
```

### List Topics
```bash
kafka-topics --list --bootstrap-server localhost:9092
```

### Describe a Topic
```bash
kafka-topics --describe --topic my-topic --bootstrap-server localhost:9092
```

### Delete a Topic
```bash
kafka-topics --delete --topic new-topic --bootstrap-server localhost:9092
```

## Producing and Consuming Messages

### Start a Producer
```bash
kafka-console-producer --topic my-topic --bootstrap-server localhost:9092
```

### Consume Messages
```bash
kafka-console-consumer --topic my-topic --bootstrap-server localhost:9092 --from-beginning
```

## Consumer Groups

### Consume with Consumer Group
Start multiple consumers in the same group to demonstrate load balancing:

```bash
kafka-console-consumer --topic my-topic --bootstrap-server localhost:9092 --group my-group --from-beginning
```

### Produce Messages with Keys
Use a producer that parses keys:

```bash
kafka-console-producer --topic my-topic --bootstrap-server localhost:9092 --property "parse.key=true" --property "key.separator=:"
```

### Describe Consumer Group
```bash
kafka-consumer-groups --describe --group my-group --bootstrap-server localhost:9092
```

## Spring Kafka Integration

### Prerequisites
- Java 11 or higher
- Maven or Gradle
- Spring Boot 2.7+ (for Spring Kafka 2.8+)

### Setting Up a Spring Boot Project
Create a new Spring Boot project using Spring Initializr (https://start.spring.io) or your IDE.

Add the following dependency to your `pom.xml` (for Maven):

```xml
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
</dependency>
```

Or for Gradle (`build.gradle`):

```gradle
implementation 'org.springframework.kafka:spring-kafka'
```

### Application Configuration
Add Kafka configuration to `application.properties` or `application.yml`:

```properties
spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=my-group
spring.kafka.consumer.auto-offset-reset=earliest
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=org.apache.kafka.common.serialization.StringDeserializer
```

### Creating a Kafka Producer
```java
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send("my-topic", message);
    }
}
```

### Creating a Kafka Consumer
```java
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
```

### Running the Application
Run your Spring Boot application. The producer can send messages, and the consumer will receive them automatically.