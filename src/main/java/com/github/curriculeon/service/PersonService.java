package com.github.curriculeon.service;

import com.github.curriculeon.dao.RepositoryInterface;
import com.github.curriculeon.model.Person;

/**
 * Created by leon on 8/13/2020.
 */ // TODO - extend AbstractService<Long, Person, PersonRepository>
public class PersonService extends AbstractService<Long, Person, RepositoryInterface<Long, Person>> {
    public PersonService(RepositoryInterface<Long, Person> repository) {
        super(repository);
    }
}
