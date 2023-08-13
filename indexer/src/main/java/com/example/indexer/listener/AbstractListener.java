package com.example.indexer.listener;

import com.example.indexer.service.IndexerService;
import com.example.lucene.model.IndexType;


public abstract class AbstractListener {
  protected final IndexerService indexerService;

  public AbstractListener(IndexerService indexerService) {
    this.indexerService = indexerService;
  }

  protected abstract IndexType getDocType();
}
