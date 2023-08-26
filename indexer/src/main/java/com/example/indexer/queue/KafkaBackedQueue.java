package com.example.indexer.queue;

import com.example.kafka.model.IndexMessage;
import com.example.kafka.producer.KafkaProducer;
import com.example.lucene.model.IndexType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

public class KafkaBackedQueue implements AbstractQueue {
  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaBackedQueue.class);

  private final KafkaProducer producer;
  private final IndexType indexType;

  public KafkaBackedQueue(IndexType indexType, KafkaProducer kafkaProducer) {
    this.indexType = indexType;
    this.producer = kafkaProducer;
  }

  @Override
  public void put(List<Integer> ids) {
    for (var id : ids) {
      producer.send(indexType.name(), IndexMessage.builder().withId(id).build());
      LOGGER.info("sent {} for {}", id, indexType);
    }
  }

  @Override
  public List<String> take(int amount) {
    return Collections.emptyList();
  }
}
