package com.example.indexer.config;

import com.example.indexer.service.IndexerService;
import com.example.kafka.KafkaListenerContainer;
import com.example.kafka.config.KafkaCommonConfig;
import com.example.kafka.listener.KafkaListener;
import com.example.kafka.wrappers.KafkaConsumerFactoryWrapper;
import com.example.lucene.model.IndexType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Import({
    KafkaCommonConfig.class,
    KafkaListenerContainer.class
})
@Configuration
public class KafkaConfig {
  @Bean
  public KafkaListener bookListener(KafkaConsumerFactoryWrapper kafkaConsumerFactoryWrapper, IndexerService indexerService) {
    return KafkaListener.Builder
        .factory(kafkaConsumerFactoryWrapper)
        .topic("book_index")
        .listen(id -> indexerService.index(IndexType.BOOK, id));
  }

  @Bean
  public KafkaListener otherListener(KafkaConsumerFactoryWrapper kafkaConsumerFactoryWrapper, IndexerService indexerService) {
    return KafkaListener.Builder
        .factory(kafkaConsumerFactoryWrapper)
        .topic("book_index")
        .listen(id -> indexerService.index(IndexType.AUTHOR, id));
  }
}
