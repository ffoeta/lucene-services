package com.example.searcher;

import com.example.searcher.config.ContextConfig;
import com.example.searcher.config.CommonConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

public class Runner {
  private static final Logger log = LoggerFactory.getLogger(Runner.class);
  public static void main(String[] args) throws Exception {
    try {
      new AnnotationConfigApplicationContext(ContextConfig.class)
          .registerShutdownHook();
    } catch (Exception e) {
      log.error("Failed to instantiate configuration context", e);
      System.exit(1);
    }
  }
}