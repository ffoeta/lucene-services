package com.example.indexer.servlet;

import com.example.indexer.dto.IndexDto;
import com.example.indexer.dto.IndexResponse;
import com.example.indexer.service.IndexerService;
import com.example.indexer.service.QueueService;
import com.example.runner.dto.ServletResponse;
import com.example.runner.servlet.AbstractServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class IndexServlet extends AbstractServlet {

  QueueService queueService;

  public IndexServlet(QueueService queueService) {
    this.queueService = queueService;
  }

  @Override
  public ServletResponse perform(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
    var body = parseBody(IndexDto.class, httpServletRequest);
    queueService.put(body.getIndexType(), body.getIds());
    return ServletResponse.of(new IndexResponse(-1));
  }
}
