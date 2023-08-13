package com.example.indexer.dto;


import com.example.runner.model.proto.BaseEntity;

public class BookResponse implements BaseEntity {

  private int count;

  public BookResponse(int count) {
    this.count = count;
  }

  public BookResponse() {
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  @Override
  public String name() {
    return "searchResponse";
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("{");
    sb.append("count=").append(count);
    sb.append('}');
    return sb.toString();
  }
}
