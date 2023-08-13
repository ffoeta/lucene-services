//package com.example.demo.service;
//
//import com.example.demo.dto.SearchDto;
//import com.example.demo.model.Book;
//import com.example.demo.model.enums.IndexType;
//import com.example.demo.model.enums.SearchType;
//import com.example.demo.repository.BookRepository;
//import com.example.demo.service.index.IndexerService;
//import com.example.demo.utils.Randomizer;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
//@ExtendWith(MockitoExtension.class)
//public class SearchServiceTest {
//
//  private static final List<Book> books = List.of(
//      Randomizer.randomBook(),
//      Randomizer.randomBook()
//  );
//
//  @Mock
//  BookRepository bookRepository;
//
//  @InjectMocks
//  IndexerService indexerService;
//
//  SearchService searchService = new SearchService();
//
//  @BeforeEach
//  public void setUp() {
//    indexerService.clearIndex(IndexType.BOOK);
//  }
//
//  @Test
//  void dotest() {
////    Mockito.when(bookRepository.findAll()).thenReturn(books);
////    indexerService.reindex(IndexType.BOOK);
//
//    var searchDto = new SearchDto(books.get(0).getTitle(), SearchType.TEXT, IndexType.BOOK);
//    var result = searchService.performIndexSearch(searchDto);
//    assertEquals(1l, result.getTotalHits());
//  }
//
//  @Test
//  void dotest2() {
//    Book book1 = new Book();
//    book1.setTitle("cars");
//
//    Book book2 = new Book();
//    book2.setTitle("car's");
//
//    Mockito.when(bookRepository.findAll()).thenReturn(List.of(book1, book2));
//    indexerService.reindex(IndexType.BOOK);
//
//    var searchDto = new SearchDto("car", SearchType.COUNT, IndexType.BOOK);
//    var result = searchService.performIndexSearch(searchDto);
//    assertEquals(2l, result.getTotalHits());
//
//    searchDto = new SearchDto("car", SearchType.EXACT, IndexType.BOOK);
//    result = searchService.performIndexSearch(searchDto);
//    assertEquals(0l, result.getTotalHits());
//
//    searchDto = new SearchDto("cars", SearchType.EXACT, IndexType.BOOK);
//    result = searchService.performIndexSearch(searchDto);
//    assertEquals(1l, result.getTotalHits());
//
//    searchDto = new SearchDto("car's", SearchType.EXACT, IndexType.BOOK);
//    result = searchService.performIndexSearch(searchDto);
//    assertEquals(1l, result.getTotalHits());
//  }
//}
