package com.example.indexer.config;

import org.springframework.context.annotation.Import;

@Import({
    CommonConfig.class,
    QueueConfig.class
})
public class ContextConfig {
}
