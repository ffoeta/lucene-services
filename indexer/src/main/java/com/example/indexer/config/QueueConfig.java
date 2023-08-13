package com.example.indexer.config;

import com.example.indexer.queue.AbstractQueue;
import com.example.indexer.queue.KafkaBackedQueue;
import com.example.indexer.service.KafkaService;
import com.example.indexer.service.QueueService;
import com.example.kafka.config.KafkaConsumerConfig;
import com.example.kafka.config.KafkaProducerConfig;
import com.example.kafka.config.KafkaTopicConfig;
import com.example.kafka.settings.KafkaSettings;
import com.example.lucene.model.IndexType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.EnumMap;
import java.util.Map;

import static com.example.indexer.config.CommonConfig.SUPPORTED_TYPES;

@Import({
    KafkaSettings.class,
    KafkaTopicConfig.class,
    KafkaProducerConfig.class,
    KafkaConsumerConfig.class,
    KafkaService.class,
    QueueService.class
})
@Configuration
public class QueueConfig {
  private AbstractQueue queue(IndexType indexType, KafkaService kafkaService) {
    return new KafkaBackedQueue(indexType, kafkaService);
  }

  @Bean
  Map<IndexType, AbstractQueue> type2queue(KafkaService kafkaService) {
    EnumMap<IndexType, AbstractQueue> type2queue = new EnumMap<>(IndexType.class);
    for (IndexType type : SUPPORTED_TYPES) {
      type2queue.put(type, queue(type, kafkaService));
    }
    return type2queue;
  }
}
