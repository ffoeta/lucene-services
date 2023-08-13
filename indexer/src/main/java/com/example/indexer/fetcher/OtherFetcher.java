package com.example.indexer.fetcher;

import com.example.indexer.queue.AbstractQueue;
import com.example.lucene.model.IndexType;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OtherFetcher extends AbstractFetcher {
  public OtherFetcher(Map<IndexType, AbstractQueue> type2queue) {
      super(type2queue.get(IndexType.OTHER));
    }

  @Override
  protected IndexType getDocType() {
    return IndexType.OTHER;
  }
}
