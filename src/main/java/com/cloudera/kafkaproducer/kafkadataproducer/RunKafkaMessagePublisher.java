package com.cloudera.kafkaproducer.kafkadataproducer;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.cloudera.kafkaproducer.properties.GetConfigurations;

import java.io.IOException;

public class RunKafkaMessagePublisher {

 private static Logger logger = Logger.getLogger(RunKafkaMessagePublisher.class);

    public static void main(String[] args) throws IOException {

        new GetConfigurations(args[0]); /* Loads the producer properties from config file
                                        into the memory*/

        /*
          Instantiates kafka data producer.ProducerWithThreads by providing necessary arguments
          through parameterized constructor to start the publisher

         */
        logger.info("Instantiating Kafka Data Producer \n ");
        ProducerWithThreads producerWithThreads = new ProducerWithThreads(GetConfigurations.getNumoftasksForParallelism(),
                GetConfigurations.getRECORD(),
                GetConfigurations.getNumberOfMessages(),
                GetConfigurations.getBootstrapServersConfig(),
                GetConfigurations.getKafkaTopic());
        producerWithThreads.spinThreads();



    }
}
