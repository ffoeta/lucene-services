package com.example.indexer.listener;

import com.example.indexer.service.IndexerService;
import com.example.kafka.config.wrappers.KafkaConsumerFactoryWrapper;
import com.example.kafka.model.IndexMessage;

public class AuthorListener extends AbstractListener<IndexMessage> {
  public AuthorListener(String topic, KafkaConsumerFactoryWrapper kafkaConsumerFactoryWrapper, IndexerService indexerService) {
    super(topic, kafkaConsumerFactoryWrapper, indexerService);
  }
}
