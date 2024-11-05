package com.github.curriculeon.jpa.personcontroller;

import com.github.curriculeon.DatabaseConnection;
import com.github.curriculeon.config.JpaConfigurator;
import com.github.curriculeon.controllers.PersonController;
import com.github.curriculeon.dao.PersonJpaRepository;
import com.github.curriculeon.service.PersonService;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 8/14/2020.
 */
public class DisplayAllTest {

    @Before
    public void setup() {
        // given
        DatabaseConnection.TESTING_DATABASE.drop(); // TODO - configure in `persistence.xml`
        DatabaseConnection.TESTING_DATABASE.create(); // TODO - configure in `persistence.xml`
        JpaConfigurator configurator = new JpaConfigurator("testing");
        configurator.appendSqlScript("testing.person_create-table.sql");
        configurator.appendSqlScript("testing.person_populate-table.sql");
        configurator.initialize();
    }

    @Test
    public void test() {
        System.out.println("inside test");
        // given
        PersonController personController = new PersonController(new PersonService(new PersonJpaRepository("testing")));
        // when
        personController.displayAll();

        // then

    }
}