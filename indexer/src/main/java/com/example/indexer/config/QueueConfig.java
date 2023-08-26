package com.example.indexer.config;

import com.example.indexer.queue.AbstractQueue;
import com.example.indexer.queue.KafkaBackedQueue;
import com.example.indexer.service.QueueService;
import com.example.kafka.producer.KafkaProducer;
import com.example.lucene.model.IndexType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

@Import({
    KafkaConfig.class
})
@Configuration
public class QueueConfig {
  public static final Set<IndexType> SUPPORTED_TYPES = Set.of(
      IndexType.BOOK,
      IndexType.AUTHOR
  );
  private AbstractQueue queue(IndexType indexType, KafkaProducer producer) {
    return new KafkaBackedQueue(indexType, producer);
  }

  @Bean
  Map<IndexType, AbstractQueue> type2queue(KafkaProducer producer) {
    EnumMap<IndexType, AbstractQueue> type2queue = new EnumMap<>(IndexType.class);
    for (IndexType type : SUPPORTED_TYPES) {
      type2queue.put(type, queue(type, producer));
    }
    return type2queue;
  }

  @Bean
  QueueService queueService(Map<IndexType, AbstractQueue> type2queue) {
    return new QueueService(type2queue);
  }
}
