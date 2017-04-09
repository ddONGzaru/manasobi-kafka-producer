package io.manasobi.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tv.anypoint.domain.ImpressionLog;
import tv.anypoint.domain.ImpressionLogSerializer;

import java.util.Properties;

/**
 * Created by twjang on 15. 10. 26.
 */
@Component
public class ProducerFactory {

    private static KafkaProducer<String, ImpressionLog> producer;

    public static KafkaProducer<String, ImpressionLog> getInstance() {

        if (producer == null) {
            producer = buildProducer();
        }
        return producer;
    }


    private static String metadataBrokerList;

    @Value("${kafka.metadata.broker.list}")
    public void setMetadataBrokerList(String metadataBrokerList) {
        ProducerFactory.metadataBrokerList = metadataBrokerList;

        System.out.println("broker list: " + metadataBrokerList);
    }

    private static KafkaProducer<String, ImpressionLog> buildProducer() {

        Properties props = new Properties();
        props.put("bootstrap.servers", metadataBrokerList);
        //props.put("metadata.broker.list", metadataBrokerList);
        props.put("partitioner.class", RoundRobinPartitioner.class.getName());
        props.put("compression.codec", "2");
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", ImpressionLogSerializer.class.getName());

        //ProducerConfig producerConfig = new ProducerConfig(props);

        return new KafkaProducer<>(props);
    }
}