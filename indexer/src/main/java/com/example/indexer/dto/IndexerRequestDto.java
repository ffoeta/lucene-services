package com.example.indexer.dto;

import com.example.lucene.model.IndexType;
import com.example.runner.model.proto.BaseEntity;

import java.util.List;

public class IndexerRequestDto implements BaseEntity {
  private IndexType indexType;
  private List<Integer> ids;

  public IndexerRequestDto() {
  }

  public IndexType getIndexType() {
    return indexType;
  }

  public void setIndexType(IndexType indexType) {
    this.indexType = indexType;
  }

  public List<Integer> getIds() {
    return ids;
  }

  public void setIds(List<Integer> ids) {
    this.ids = ids;
  }

  @Override
  public String name() {
    return "indexerRequest";
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("{");
    sb.append("indexType=").append(indexType);
    sb.append(", ids=").append(ids);
    sb.append('}');
    return sb.toString();
  }
}
