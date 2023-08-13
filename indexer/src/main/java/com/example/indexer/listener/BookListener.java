package com.example.indexer.listener;

import com.example.indexer.service.IndexerService;
import com.example.kafka.config.KafkaConsumerConfig;
import com.example.lucene.model.IndexType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.listener.MessageListenerContainer;

import java.util.UUID;

public class BookListener extends AbstractListener {
  private static final Logger log = LoggerFactory.getLogger(BookListener.class);

  public BookListener(IndexerService indexerService) {
    super(indexerService);
  }

  @Bean
  public MessageListenerContainer bookListener(ConsumerFactory<String, String> consumerFactory) {
    return KafkaConsumerConfig.createListener(consumerFactory, getDocType().name(),
        (MessageListener<Object, String>) data -> {
          var id = UUID.fromString(data.value());
          indexerService.indexDocs(getDocType(), id);
        });
  }

  @Override
  protected IndexType getDocType() {
    return IndexType.BOOK;
  }
}
