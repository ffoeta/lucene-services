package com.example.indexer.parser;


import com.example.indexer.model.Author;
import com.example.indexer.model.Book;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.KeywordField;
import org.apache.lucene.document.TextField;

public class DocParser {

  public static Document parseBook(Book book) {
    var document = new Document();

    var id = new IntField("id", book.getId(), Field.Store.YES);
    var title = new TextField("title", book.getTitle(), Field.Store.YES);
    var desc = new TextField("description", book.getDescription(), Field.Store.YES);
    var genre = new KeywordField("genre", book.getGenre().name(), Field.Store.YES);

    document.add(id);
    document.add(title);
    document.add(desc);
    document.add(genre);

    return document;
  }

  public static Document parseAuthor(Author author) {
    var document = new Document();

    var id = new IntField("id", author.getId(), Field.Store.YES);
    var name = new TextField("name", author.getName(), Field.Store.YES);

    document.add(id);
    document.add(name);

    return document;
  }
}
