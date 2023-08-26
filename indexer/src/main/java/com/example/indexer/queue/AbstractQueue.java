package com.example.indexer.queue;

import java.util.List;

public interface AbstractQueue {
  public void put(List<Integer> messages);

  public List<String> take(int amount);
}
