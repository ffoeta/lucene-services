package com.example.indexer.servlet;


import com.example.indexer.dto.BookResponse;
import com.example.indexer.service.BookService;
import com.example.runner.dto.ServletResponse;
import com.example.runner.servlet.AbstractServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class BookServlet extends AbstractServlet {

  private BookService bookService;

  public BookServlet(BookService bookService) {
    this.bookService = bookService;
  }

  @Override
  public ServletResponse perform(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
    var count = bookService.count();
    return ServletResponse.of(new BookResponse(count));
  }
}
