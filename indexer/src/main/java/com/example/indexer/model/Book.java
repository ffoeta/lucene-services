package com.example.indexer.model;

import com.example.indexer.model.enums.Genre;
import com.example.runner.model.proto.BaseEntity;

import java.time.LocalDateTime;

public class Book implements BaseEntity {
  private Integer id;

  private String title;

  private String description;

  private Genre genre;

  private LocalDateTime date;

  public Book() {
  }

  @Override
  public String name() {
    return "book";
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Genre getGenre() {
    return genre;
  }

  public void setGenre(Genre genre) {
    this.genre = genre;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Book{");
    sb.append("id=").append(id);
    sb.append(", title='").append(title).append('\'');
    sb.append(", description='").append(description).append('\'');
    sb.append(", genre=").append(genre);
    sb.append(", date=").append(date);
    sb.append('}');
    return sb.toString();
  }
}
