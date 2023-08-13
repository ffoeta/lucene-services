package com.example.indexer.config;

import com.example.indexer.fetcher.BookFetcher;
import com.example.indexer.fetcher.OtherFetcher;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
    BookFetcher.class,
    OtherFetcher.class
})
@Configuration
public class FetcherConfig {
}
