package com.example.indexer.util;

import com.example.indexer.queue.AbstractQueue;
import com.example.lucene.model.IndexType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import java.util.Map;

import static com.example.indexer.util.Randomizer.randomBookMessages;
import static com.example.indexer.util.Randomizer.randomOtherMessages;

@Component
public class LoadProducer extends StoppableThread {
  private static final Logger log = LoggerFactory.getLogger(LoadProducer.class);

  private AbstractQueue bookQueue;
  private AbstractQueue otherQueue;
  public LoadProducer(Map<IndexType, AbstractQueue> type2queue) {
    this.bookQueue = type2queue.get(IndexType.BOOK);
    this.otherQueue = type2queue.get(IndexType.OTHER);
  }

  @Override
  public void run() {
    while (!stopNow) {
      try {
        var bookList = randomBookMessages(4);
        var otherList = randomOtherMessages(5);
        log.warn("ABOUT TO DROP {} BOOKS AND {} OTHERS!", bookList.size(), otherList.size());
        bookQueue.put(bookList);
        otherQueue.put(otherList);
        sleep(5000);
      } catch (Exception e) {
        log.error("FAILED TO SLEEP");
      }
    }
  }

  @PostConstruct
  @Override
  public synchronized void start() {
    super.start();
  }

  @PreDestroy
  @Override
  public void stopNow() {
    super.stopNow();
  }
}
