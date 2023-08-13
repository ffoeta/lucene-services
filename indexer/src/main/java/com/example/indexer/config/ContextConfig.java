package com.example.indexer.config;

import com.example.indexer.util.LoadProducer;
import org.springframework.context.annotation.Import;

@Import({
    CommonConfig.class,
    QueueConfig.class,
    FetcherConfig.class,
    LoadProducer.class,
    ListenerConfig.class
})
public class ContextConfig {
}
