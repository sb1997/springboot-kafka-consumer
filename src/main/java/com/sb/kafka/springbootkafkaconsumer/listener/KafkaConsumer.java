package com.sb.kafka.springbootkafkaconsumer.listener;

import com.sb.kafka.springbootkafkaconsumer.model.User;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@EnableKafka
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "kafka_example",groupId = "group_id")
    public void consume(String message){
        System.out.println("consumed message: "+ message);
    }

    @KafkaListener(topics = "kafka_example_json",groupId = "group_json",containerFactory = "userKafkaListenerFactory")
    public void consumeJson(User user){
        System.out.println("consumed json message: "+ user);
    }
}
