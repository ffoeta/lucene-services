package com.example.indexer.service;

import com.example.indexer.dao.BookDao;
import org.springframework.stereotype.Component;

@Component
public class BookService {
  private BookDao bookDao;

  public BookService(BookDao bookDao) {
    this.bookDao = bookDao;
  }

  public int count() {
    return bookDao.getBooksCount();
  }
}
