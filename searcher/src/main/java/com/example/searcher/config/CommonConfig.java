package com.example.searcher.config;


import com.example.runner.jetty.JettyServerBuilder;
import com.example.runner.settings.JettySettings;
import com.example.searcher.service.SearchService;
import com.example.searcher.servlet.SearchServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static java.net.InetAddress.getLocalHost;

@Configuration
@Import({
    JettySettings.class,
    SearchService.class
})
public class CommonConfig {
  private static final Logger log = LoggerFactory.getLogger(CommonConfig.class);

  @Bean
  public JettyServerBuilder.JettyServer jettyServer(
      JettySettings jettySettings,
      SearchService searchService
  ) throws Exception {
    var jetty = JettyServerBuilder.jettyServerBuilder(jettySettings)
        .withServletMapping(new SearchServlet(searchService), "/search/")
        .build();

    jetty.start();

    log.info("Started jetty server at {}", getLocalHost());
    return jetty;
  }
}
