package com.example.indexer.listener;

import com.example.indexer.service.IndexerService;
import com.example.kafka.config.wrappers.KafkaConsumerFactoryWrapper;
import com.example.kafka.listener.KafkaListener;
import com.example.kafka.model.KafkaMessage;
import com.example.lucene.model.IndexType;

public abstract class AbstractListener<T extends KafkaMessage> extends KafkaListener<T> {
  protected IndexerService indexerService;
  protected IndexType indexType;

  public AbstractListener(String topic, KafkaConsumerFactoryWrapper kafkaConsumerFactoryWrapper, IndexerService indexerService) {
    super(topic, kafkaConsumerFactoryWrapper);
    this.indexerService = indexerService;
    this.indexType = IndexType.valueOf(topic);
  }

  @Override
  protected <T> void onMessage(T t) {
    var message = ((com.example.kafka.model.IndexMessage) t);
    indexerService.index(indexType, message.getId());
  }
}
