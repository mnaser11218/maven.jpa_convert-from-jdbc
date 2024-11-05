package com.github.curriculeon;

import com.github.curriculeon.config.ConfigurationInterface;
import com.github.curriculeon.config.JpaConfigurator;

/**
 * Created by leon on 8/13/2020.
 */
public class MainApplication {

    public static void main(String[] args) {
        DatabaseConnection.PRODUCTION_DATABASE.drop();
        DatabaseConnection.PRODUCTION_DATABASE.create();
        DatabaseConnection.PRODUCTION_DATABASE.use();
//        ConfigurationInterface config = new JdbcConfigurator(DatabaseConnection.PRODUCTION_DATABASE);
        ConfigurationInterface config = new JpaConfigurator("mysql");
        config.appendSqlScript("production.person_create-table.sql");
        config.appendSqlScript("production.person_populate-table.sql");
        config.initialize();
        Runnable applicationRunner = new ApplicationRunner();
        applicationRunner.run();
    }
}
