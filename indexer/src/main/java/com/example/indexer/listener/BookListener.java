package com.example.indexer.listener;

import com.example.indexer.service.IndexerService;
import com.example.kafka.config.wrappers.KafkaConsumerFactoryWrapper;
import com.example.kafka.model.IndexMessage;

public class BookListener extends AbstractListener<IndexMessage> {
  public BookListener(String topic, KafkaConsumerFactoryWrapper kafkaConsumerFactoryWrapper, IndexerService indexerService) {
    super(topic, kafkaConsumerFactoryWrapper, indexerService);
  }
}
