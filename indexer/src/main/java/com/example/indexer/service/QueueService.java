package com.example.indexer.service;

import com.example.indexer.queue.AbstractQueue;
import com.example.lucene.model.IndexType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class QueueService {
  Map<IndexType, AbstractQueue> type2queue;
  public QueueService(Map<IndexType, AbstractQueue> type2queue) {
    this.type2queue = type2queue;
  }

  public void put(IndexType indexType, List<UUID> ids) {
    type2queue.get(indexType).put(ids);
  }
}
