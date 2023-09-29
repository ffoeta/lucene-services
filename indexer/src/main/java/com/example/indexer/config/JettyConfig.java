package com.example.indexer.config;

import com.example.runner.config.JettyCommonConfig;
import com.example.runner.settings.JettySettings;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
    JettySettings.class,
    JettyCommonConfig.class,
})
@Configuration
public class JettyConfig {
}
