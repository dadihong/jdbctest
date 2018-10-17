package com.web;

import com.dao.PersonDao;
import com.dao.impl.PersonDaoImpl;
import com.person.Person;

import java.util.List;

public class PersonWeb {
    public static void main(String[] args) {
        PersonDao dao = new PersonDaoImpl();
        try {
            List<Person> allPerson = dao.findAllPerson();
            for (Person person : allPerson) {
                System.out.println(person);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
