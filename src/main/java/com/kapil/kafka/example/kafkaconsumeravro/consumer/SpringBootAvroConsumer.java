package com.kapil.kafka.example.kafkaconsumeravro.consumer;

import com.kapil.kafka.example.kafkaproduceravro.schema.StockHistory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class SpringBootAvroConsumer {

//    @KafkaListener(topics = "${avro.topic.name}", containerFactory = "kafkaListenerContainerFactory")
//    public void read(ConsumerRecord<String, StockHistory> record) {
//        String key = record.key();
//        StockHistory history = record.value();
//        System.out.println("Avro message received for key : " + key + " value : " + history.toString());
//    }

    @KafkaListener(topics = "${avro.topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void readMessage(Message<StockHistory> record) {
        StockHistory history = record.getPayload();
        System.out.println("Avro message received for Message Type : " + history.toString());
    }
}
