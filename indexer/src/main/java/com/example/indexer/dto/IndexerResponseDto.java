package com.example.indexer.dto;

import com.example.runner.model.proto.BaseEntity;

public class IndexerResponseDto implements BaseEntity {

  private String status;

  public IndexerResponseDto() {
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String name() {
    return "indexerResponse";
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("{");
    sb.append("status='").append(status).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
