package com.example.populator.config;

import com.example.data.settings.DatasourceSettings;
import com.example.populator.housekeeper.StartupHousekeeper;
import org.springframework.context.annotation.Import;

@Import({
    DatasourceSettings.class,
    StartupHousekeeper.class
})
public class CommonConfig {


}
