package com.example.indexer.service;

import com.example.indexer.model.Book;
import com.example.indexer.model.Author;
import com.example.indexer.parser.DocParser;
import com.example.indexer.session.SqlSessionTemplate;
import com.example.lucene.CustomWriter;
import com.example.lucene.model.IndexType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IndexerService {
  private static final Logger LOGGER = LoggerFactory.getLogger(IndexerService.class);

  SqlSessionTemplate sqlSessionTemplate;

  public IndexerService(SqlSessionTemplate sqlSessionTemplate) {
    this.sqlSessionTemplate = sqlSessionTemplate;
  }

  public void index(IndexType indexType, Long id) {
    LOGGER.info("got {} for {}", id, indexType);
    switch (indexType) {
      case BOOK -> indexBook(id);
      case AUTHOR -> indexOther(id);
      default -> throw new RuntimeException();
    }
  }

  private void indexBook(Long id) {
    var book = sqlSessionTemplate.getById(Book.class, "book", id);
    if (book.isEmpty()) {
      LOGGER.info("no such book in db, id={}!", id);
      return;
    }
    var doc = DocParser.parseBook(book.get());
    try (var writer = CustomWriter.buildWriterForIndex(IndexType.BOOK)) {
      writer.writeDoc(doc);
    }
  }

  private void indexOther(Long id) {
    var author = sqlSessionTemplate.getById(Author.class, "author", id);
    if (author.isEmpty()) {
      LOGGER.info("no such author in db, id={} !", id);
      return;
    }
    var doc = DocParser.parseAuthor(author.get());
    try (var writer = CustomWriter.buildWriterForIndex(IndexType.AUTHOR)) {
      writer.writeDoc(doc);
    }
  }
}
