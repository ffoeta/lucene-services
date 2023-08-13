package com.example.indexer.service;

import com.example.lucene.model.IndexType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;



//@Component
public class KafkaService {
  private static final Logger log = LoggerFactory.getLogger(KafkaService.class);

  KafkaTemplate<String, Object> kafkaTemplate;

  public KafkaService(
      KafkaTemplate<String, Object> kafkaTemplate
  ) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessages(IndexType indexType, List<String> messages) {
    for (var message: messages) {
      sendMessage(indexType, message);
    }
  }

  public void sendMessage(IndexType indexType, String message) {
    var future = kafkaTemplate.send(indexType.name(), message);
    future.addCallback(new ListenableFutureCallback<>() {
      @Override
      public void onSuccess(SendResult<String, Object> result) {
        log.info("Message [{}] delivered with offset {}", message, result.getRecordMetadata().offset());
      }

      @Override
      public void onFailure(Throwable ex) {
        log.warn("Unable to deliver message [{}]. {}", message, ex.getMessage());
      }
    });
  }

  public int listen(IndexType indexType) {
//    log.info("LISTENING  FOR TOPIC {}", indexType);
//    consumer.subscribe(Collections.singleton(indexType.name()));
//    var records = consumer.poll(Duration.ofMillis(100));
//    consumer.unsubscribe();
//    log.info("GOT {} MESSAGES", records.count());
//    return records.count();
    return 0;
  }
}
