package com.example.indexer.config;

import com.example.indexer.service.QueueService;
import com.example.indexer.servlet.IndexerServlet;
import com.example.runner.jetty.JettyServerBuilder;
import com.example.runner.settings.JettySettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import static java.net.InetAddress.getLocalHost;

@Configuration
@Import({
    JettySettings.class,
    QueueService.class,
    DataSourceConfig.class
})
public class CommonConfig {
  private static final Logger log = LoggerFactory.getLogger(CommonConfig.class);

  @Bean
  public JettyServerBuilder.JettyServer jettyServer(
      JettySettings jettySettings,
      QueueService queueService
  ) throws Exception {
    var jetty = JettyServerBuilder.jettyServerBuilder(jettySettings)
        .withServletMapping(new IndexerServlet(queueService), "/index/")
        .build();
    jetty.start();
    log.info("Started jetty server at {}", getLocalHost());
    log.info("-------------------------------------------------------");
    return jetty;
  }
}
