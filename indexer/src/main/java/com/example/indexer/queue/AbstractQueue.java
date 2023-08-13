package com.example.indexer.queue;

import java.util.List;
import java.util.UUID;

public interface AbstractQueue {
  public void put(List<UUID> messages);

  public List<String> take(int amount);
}
