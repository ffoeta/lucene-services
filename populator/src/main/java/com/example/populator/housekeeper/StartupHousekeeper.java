package com.example.populator.housekeeper;

import com.example.data.settings.DatasourceSettings;
import org.flywaydb.core.Flyway;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupHousekeeper {

  DatasourceSettings datasourceSettings;

  public StartupHousekeeper(DatasourceSettings datasourceSettings) {
    this.datasourceSettings = datasourceSettings;
  }

  @EventListener(ContextRefreshedEvent.class)
  public void contextRefreshedEvent() {
    Flyway flyway = Flyway.configure().dataSource(
        datasourceSettings.getUrl(),
        datasourceSettings.getUser(),
        datasourceSettings.getPassword())
        .load();

    flyway.migrate();
  }
}
