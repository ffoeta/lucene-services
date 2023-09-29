package com.example.indexer.config;

import org.springframework.context.annotation.Import;

@Import({
    JettyConfig.class,
    DataSourceConfig.class,
    KafkaConfig.class
})
public class ContextConfig {
}
