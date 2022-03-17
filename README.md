# KafkaDataPublisher

Kafka Data Publisher is designed and developed to be able to simulate the streaming environment using the user provided configurations. It uses Apache Kafka Producer API to publish n messages asynchronously of type String into the input Kafka topic.


## Getting Started

1. Requires JDK 1.8 or above
2. Built with Gradle 
3. Requires Kafka cluster with at least one broker to run the KafkaDataPublisher application


## Installation


gradle clean
gradle build 

```

## How to run

```groovy
step 1: create a file kafkaauthorization.jaas

step 2: copy the following contents given below into the file kafkaauthorization.jaas by replacing username with the id running the application

 KafkaClient {

 com.sun.security.auth.module.Krb5LoginModule required

 doNotPrompt=true

 useTicketCache=true

 principal=<Your principal>

 useKeyTab=true

 serviceName="kafka"

 keyTab="/u/username/username.keytab"

 client=true;

};

Client {

 com.sun.security.auth.module.Krb5LoginModule required

 doNotPrompt=true

 useTicketCache=true

 principal=<Your principal>

 useKeyTab=true

 serviceName="zookeeper"

 keyTab="/u/username/username.keytab"

 client=true;

};
    
step 3: create a file producerconfig.properties using the content in step 4

step 4: 

#Kafka-cluster-details

BOOTSTRAP_SERVERS_CONFIG=<Bootstrap server details>
KAFKA_TOPIC=<Your Kafka topic>


#Message Information

MESSAGE=<Some JSON message>
NUMBER_OF_MESSAGES=<number of messages>
NUMOFTASKS_FOR_PARALLELISM=<number of parallel threads>


#Logging constants

LOG_PATH=<Log path for application>
LOGGING_PATTERN=%d %-5p [%c{1}] %m%n
CONSOLE_LOGGING_TARGET=System.out
APP_NAME=Kafka-Data-Producer
LOG_EXTENSION = _LOGS.log

step 5: Update producerconfig.properties with appropriate values based on the requirements

step 6: Run the java command provide below to start the kafka publisher process
```



```java
java -Djava.security.auth.login.config==/u/username/kafkaauthorization.jaas -jar kafka-producer-1.0-SNAPSHOT.jar producerconfig.properties
```