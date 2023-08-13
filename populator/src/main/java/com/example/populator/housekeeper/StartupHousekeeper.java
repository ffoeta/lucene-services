package com.example.populator.service;

import com.example.commons.config.DatasourceSettings;

public class PopulatorService {

  DatasourceSettings datasourceSettings;

  public PopulatorService(DatasourceSettings datasourceSettings) {
    this.datasourceSettings = datasourceSettings;
  }

  public void populate() {

//    Flyway flyway = new Flyway();
//    flyway.setDataSource(dbConfig.getUrl(), dbConfig.getUsername(), dbConfig.getPassword());
//    flyway.setLocations("classpath:db/scripts");
//    flyway.clean();
//    flyway.migrate();
  }
}
