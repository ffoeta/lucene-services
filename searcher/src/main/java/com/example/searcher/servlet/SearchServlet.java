package com.example.searcher.servlet;

import com.example.runner.dto.ServletResponse;
import com.example.runner.servlet.AbstractServlet;
import com.example.searcher.service.SearchService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SearchServlet extends AbstractServlet {

  SearchService service;

  public SearchServlet(SearchService service) {
    this.service = service;
  }

  @Override
  public ServletResponse perform(HttpServletRequest request, HttpServletResponse response) throws IOException {
    return null;
  }

}
