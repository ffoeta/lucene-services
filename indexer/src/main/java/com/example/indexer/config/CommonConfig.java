package com.example.indexer.config;


import com.example.data.config.DatasourceConfig;
import com.example.data.settings.DatasourceSettings;
import com.example.indexer.dao.BookDao;
import com.example.indexer.service.BookService;
import com.example.indexer.service.IndexerService;
import com.example.indexer.service.QueueService;
import com.example.indexer.servlet.BookServlet;
import com.example.indexer.servlet.IndexServlet;
import com.example.lucene.model.IndexType;
import com.example.runner.jetty.JettyServerBuilder;
import com.example.runner.settings.JettySettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Set;

import static java.net.InetAddress.getLocalHost;

@Configuration
@Import({
    JettySettings.class,
    DatasourceSettings.class,
    DatasourceConfig.class,
    IndexerService.class,
    QueueService.class,
    BookService.class,
    BookDao.class
})
public class CommonConfig {
  private static final Logger log = LoggerFactory.getLogger(CommonConfig.class);
  public static final Set<IndexType> SUPPORTED_TYPES = Set.of(
      IndexType.BOOK,
      IndexType.OTHER
  );

  @Bean
  public JettyServerBuilder.JettyServer jettyServer(
      JettySettings jettySettings,
      QueueService queueService,
      BookService bookService
  ) throws Exception {
    var jetty = JettyServerBuilder.jettyServerBuilder(jettySettings)
        .withServletMapping(new BookServlet(bookService), "/book/")
        .withServletMapping(new IndexServlet(queueService), "/index/")
        .build();

    jetty.start();

    log.info("Started jetty server at {}", getLocalHost());
    log.info("-------------------------------------------------------");

    return jetty;
  }
}
