package com.example.indexer.dto;

import com.example.lucene.model.IndexType;

import java.util.List;
import java.util.UUID;

public class IndexDto {
  private IndexType indexType;
  private List<UUID> ids;

  public IndexDto() {
  }

  public IndexType getIndexType() {
    return indexType;
  }

  public void setIndexType(IndexType indexType) {
    this.indexType = indexType;
  }

  public List<UUID> getIds() {
    return ids;
  }

  public void setIds(List<UUID> ids) {
    this.ids = ids;
  }
}
