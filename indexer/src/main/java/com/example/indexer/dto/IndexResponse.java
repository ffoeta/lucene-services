package com.example.indexer.dto;

import com.example.runner.model.proto.BaseEntity;

public class IndexResponse implements BaseEntity {
  private int indexedCount;

  public IndexResponse(int indexedCount) {
    this.indexedCount = indexedCount;
  }

  public int getIndexedCount() {
    return indexedCount;
  }

  public void setIndexedCount(int indexedCount) {
    this.indexedCount = indexedCount;
  }

  @Override
  public String name() {
    return "index";
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("{");
    sb.append("indexedCount=").append(indexedCount);
    sb.append('}');
    return sb.toString();
  }
}
