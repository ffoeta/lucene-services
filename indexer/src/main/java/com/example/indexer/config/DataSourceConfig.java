package com.example.indexer.config;

import com.example.data.config.DatasourceConfig;
import com.example.data.settings.DatasourceSettings;
import com.example.indexer.session.SqlSessionTemplate;
import com.example.indexer.service.IndexerService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
    DatasourceSettings.class,
    DatasourceConfig.class,
    SqlSessionTemplate.class,
    IndexerService.class
})
@Configuration
public class DataSourceConfig {
}
