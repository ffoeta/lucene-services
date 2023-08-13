package com.example.indexer.config;

import com.example.indexer.listener.BookListener;
import com.example.indexer.listener.OtherListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
    BookListener.class,
    OtherListener.class
})
@Configuration
public class ListenerConfig {
}
