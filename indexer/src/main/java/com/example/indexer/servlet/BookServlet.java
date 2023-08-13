package com.example.indexer.servlet;


import com.example.indexer.dto.SearchResponse;
import com.example.indexer.service.BookService;
import com.example.indexer.service.IndexerService;
import com.example.runner.dto.ServletResponse;
import com.example.runner.servlet.AbstractServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class IndexServlet extends AbstractServlet {

  private IndexerService indexerService;
  private BookService bookService;

  public IndexServlet(IndexerService indexerService, BookService bookService) {
    this.indexerService = indexerService;
    this.bookService = bookService;
  }

  @Override
  public ServletResponse perform(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
    var count = bookService.count();
    return ServletResponse.of(new SearchResponse(count));
  }
}
