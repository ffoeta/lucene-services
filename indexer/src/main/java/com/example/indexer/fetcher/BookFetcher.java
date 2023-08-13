package com.example.indexer.fetcher;

import com.example.indexer.queue.AbstractQueue;
import com.example.lucene.model.IndexType;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BookFetcher extends AbstractFetcher {

  public BookFetcher(Map<IndexType, AbstractQueue> type2queue) {
    super(type2queue.get(IndexType.BOOK));
  }

  @Override
  protected IndexType getDocType() {
    return IndexType.BOOK;
  }
}
