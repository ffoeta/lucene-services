package com.example.searcher.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SearchService {
  private static final Logger LOG = LoggerFactory.getLogger(SearchService.class);

  public static final List<String> FIELDS = List.of("title");
  public static final List<String> FIELDS_EXACT = List.of("title_");

//  public SearchResult performIndexSearch(SearchRequest searchRequest) {
//    var searchType = searchRequest.getSearchType();
//    var text = searchRequest.getText();
//    var indexType = searchRequest.getIndexType();
//
//    var countQuery = false;
//    List<String> fields;
//    if (searchType.equals(SearchType.EXACT)) {
//      fields = FIELDS_EXACT;
//    } else {
//      fields = FIELDS;
//    }
//
//    Query query = buildQuery(text, fields);
//    BaseCollector collector;
//
//    if (SearchType.COUNT.equals(searchType)) {
//      collector = new CountCollector();
//    } else {
//      collector = new DefaultCollector();
//    }
//
//    return search(indexType, query, collector, true);
//  }
//
//  public SearchResult search(IndexType indexType, Query query, BaseCollector collector, boolean withFacets) {
//    try (
//        var searcher = CustomSearcher.buildReaderForIndex(indexType);
//    ) {
//      BaseCollector finalCollector = collector;
//      if (withFacets) {
//        //
//      }
//      return searcher.search(query, finalCollector);
//    } catch (CustomIndexUserException e) {
//      LOG.warn("FAILED TO SEARCH");
//      return SearchResult.empty();
//    }
//  }
//
//  private Query buildQuery(String text, List<String> fields) {
//    var builder = new BooleanQuery.Builder();
//    for (var field: fields) {
//      builder.add(new TermQuery(new Term(field, text)), BooleanClause.Occur.SHOULD);
//    }
//    return builder.build();
//  }
//
//  private BaseCollector getCollector(SearchType searchType) {
//    if (SearchType.COUNT.equals(searchType)) {
//      return new CountCollector();
//    } else {
//      return new DefaultCollector();
//    }
//  }
}
