package com.example.indexer.fetcher;

import com.example.indexer.queue.AbstractQueue;
import com.example.indexer.util.StoppableThread;
import com.example.lucene.model.IndexType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public abstract class AbstractFetcher extends StoppableThread {
  private static final Logger log = LoggerFactory.getLogger(AbstractFetcher.class);

  AbstractQueue abstractQueue;

  public AbstractFetcher(AbstractQueue abstractQueue) {
    this.abstractQueue = abstractQueue;
  }

  @Override
  public void run() {
    while (!stopNow) {
      try {
        log.info("TAKEN {} DOCS OF TYPE {}", 0, getDocType());
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

  protected abstract IndexType getDocType();
}
