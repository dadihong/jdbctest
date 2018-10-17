package com.dao;

import com.person.Person;

import java.util.List;

public interface PersonDao {
    public List<Person> findAllPerson() throws Exception;
}
