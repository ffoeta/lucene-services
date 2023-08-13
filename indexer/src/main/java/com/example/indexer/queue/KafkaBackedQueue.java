package com.example.indexer.queue;

import com.example.indexer.service.KafkaService;
import com.example.lucene.model.IndexType;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class KafkaBackedQueue implements AbstractQueue {

  private final KafkaService kafkaService;
  private final IndexType indexType;

  public KafkaBackedQueue(IndexType indexType, KafkaService kafkaService) {
    this.indexType = indexType;
    this.kafkaService = kafkaService;
  }

  @Override
  public void put(List<UUID> messages) {
    if (kafkaService != null)
      kafkaService.sendMessages(indexType, messages.stream().map(UUID::toString).toList());
  }

  @Override
  public List<String> take(int amount) {
    return Collections.emptyList();
  }
}
