package com.example.indexer.model;

import com.example.runner.model.proto.BaseEntity;

public class Author implements BaseEntity {
  private Integer id;
  private String name;

  public Author() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String name() {
    return "author";
  }
}
