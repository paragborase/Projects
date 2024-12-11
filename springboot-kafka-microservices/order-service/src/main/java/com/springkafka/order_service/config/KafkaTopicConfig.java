package com.springkafka.order_service.config;

import com.springkafka.base_domains.dto.Order;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    //spring bean for kafka topic
    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(topicName)
                //.partitions(3) using default partition
                .build();
    }

}
