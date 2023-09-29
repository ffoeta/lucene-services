package com.example.indexer.config.kafka;

import com.example.kafka.KafkaListenerContainer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Import({
    KafkaListenerConfig.class,
    KafkaListenerContainer.class
})
@Configuration
public class KafkaConfig {
}
