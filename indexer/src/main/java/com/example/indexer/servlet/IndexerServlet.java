package com.example.indexer.servlet;

import com.example.indexer.dto.IndexerRequestDto;
import com.example.indexer.dto.IndexerResponseDto;
import com.example.indexer.service.QueueService;
import com.example.runner.dto.ServletResponse;
import com.example.runner.servlet.AbstractServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class IndexerServlet extends AbstractServlet {

  QueueService service;

  public IndexerServlet(QueueService service) {
    this.service = service;
  }

  @Override
  public ServletResponse perform(HttpServletRequest request, HttpServletResponse response) throws IOException {
    var body = parseBody(IndexerRequestDto.class, request);
    service.put(body.getIndexType(), body.getIds());
    var dto = new IndexerResponseDto();
    dto.setStatus("put");
    return ServletResponse.of(dto);
  }
}