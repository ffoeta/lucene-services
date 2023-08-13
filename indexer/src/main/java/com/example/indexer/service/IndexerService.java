package com.example.indexer.service;

import com.example.indexer.dao.BookDao;
import com.example.indexer.dto.IndexDto;
import com.example.lucene.model.IndexType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class IndexerService {
  private static final Logger log = LoggerFactory.getLogger(IndexerService.class.getName());

  private BookDao bookDao;

  public IndexerService(BookDao bookDao) {
    this.bookDao = bookDao;
  }

  public int indexDocs(IndexDto indexDto) {
    return indexDocs(indexDto.getIndexType(), indexDto.getIds());
  }

  public int indexDocs(IndexType indexType, List<UUID> ids) {
    for (var id: ids) {
      log.info("INDEXED DOC {} OF TYPE {}", id, indexType);
    }
    return ids.size();
  }

  public void indexDocs(IndexType indexType, UUID id) {
      log.info("INDEXED DOC {} OF TYPE {}", id, indexType);
  }
}
