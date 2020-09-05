package com.github.curriculeon.dao;


import com.github.curriculeon.DatabaseConnection;
import com.github.curriculeon.DatabaseConnectionInterface;
import com.github.curriculeon.model.Person;
import com.github.curriculeon.model.PersonBuilder;
import com.github.curriculeon.orm.PersonOrm;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by leon on 8/13/2020.
 */ // TODO - extend `RepositoryInterface<Long, Person>`
public class PersonJdbcRepository extends AbstractJdbcRepository<Long, Person> {
    public PersonJdbcRepository(DatabaseConnectionInterface databaseConnection) {
        super(databaseConnection);
    }

    public PersonJdbcRepository() {
        this(DatabaseConnection.PRODUCTION_DATABASE);
    }

    @Override
    public List<Person> findAll() {
        String query = "SELECT * FROM Person;";
        ResultSet resultSet = getDatabaseConnection().executeQuery(query);
        return new PersonOrm(resultSet).toList();
    }

    @Override
    public Person update(Person existingEntity, Person newData) {
        return new PersonBuilder(newData)
                .setId(existingEntity.getId())
                .build();
    }

    @Override
    public Person delete(Person entity) {
        Long id = entity.getId();
        String statement = "DELETE FROM Person WHERE id = " + id + ";";
        Person person = this.findById(id).get();
        getDatabaseConnection().executeStatement(statement);
        return person;
    }
}
