package com.example.populator;

import com.example.populator.config.ContextConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
  private static final Logger log = LoggerFactory.getLogger(Runner.class);

  public static void main(String[] args) {
    try {
      new AnnotationConfigApplicationContext(ContextConfig.class)
          .registerShutdownHook();
    } catch (Exception e) {
      log.error("Failed to instantiate configuration context", e);
      System.exit(1);
    }
  }
}
