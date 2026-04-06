### Spring Kafka Beginner Course
- Enter kafka terminal from `cmd`
    `docker exec -it kafka-spring-springcloud-kafka-1 bash`
- create a topic `kafka-topics --create --topic my-topic --bootstrap-server localhost:9092 --partitions 3 --replication-factor 1`
- see the topic list `kafka-topics --list --bootstrap-server localhost:9092`
- describe a kafka topic `kafka-topics --describe --topic my-topic --bootstrap-server localhost:9092`
- enter kafka producer `kafka-console-producer --topic my-topic --bootstrap-server localhost:9092`
- consume kafka message from producer `kafka-console-consumer --topic my-topic --bootstrap-server localhost:9092 --from-beginning`
- communicate between producers and consumers 
    `kafka-console-consumer --topic my-topic --bootstrap-server localhost:9092 --group my-group --from-beginning`, 
    `kafka-console-consumer --topic my-topic --bootstrap-server localhost:9092 --group my-group --from-beginning`, 
    `kafka-console-producer --topic my-topic --bootstrap-server localhost:9092 --property "parse.key=true" --property "key.separator=:"`
- describe a consumer group `kafka-consumer-groups --bootstrap-server localhost:9092 --describe --group my-group`
- delte a kafka topic `kafka-topics --bootstrap-server localhost:9092 --delete --topic new-topic`

kafka-console-producer --topic my-topic --bootstrap-server localhost:9092 --property "parse.key=true" --property "key.separator=:"
kafka-console-producer --topic my-topic --bootstrap-server localhost:9092 --property "parse.key=true" --peoperty "key.separator=:"