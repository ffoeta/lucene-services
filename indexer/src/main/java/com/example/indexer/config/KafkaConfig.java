package com.example.indexer.config;

import com.example.indexer.listener.BookListener;
import com.example.indexer.listener.AuthorListener;
import com.example.indexer.service.IndexerService;
import com.example.kafka.config.KafkaConsumerConfig;
import com.example.kafka.config.KafkaListenersContainer;
import com.example.kafka.config.KafkaProducerConfig;
import com.example.kafka.config.KafkaTopicConfig;
import com.example.kafka.config.wrappers.KafkaConsumerFactoryWrapper;
import com.example.kafka.settings.KafkaSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
    KafkaSettings.class,
    KafkaTopicConfig.class,
    KafkaProducerConfig.class,
    KafkaConsumerConfig.class,
    KafkaListenersContainer.class,
    DataSourceConfig.class,
})
@Configuration
public class KafkaConfig {
  @Bean
  public BookListener bookListener(KafkaConsumerFactoryWrapper kafkaConsumerFactoryWrapper, IndexerService indexerService) {
    return new BookListener("BOOK", kafkaConsumerFactoryWrapper, indexerService);
  }

  @Bean
  public AuthorListener otherListener(KafkaConsumerFactoryWrapper kafkaConsumerFactoryWrapper, IndexerService indexerService) {
    return new AuthorListener("AUTHOR", kafkaConsumerFactoryWrapper, indexerService);
  }
}
