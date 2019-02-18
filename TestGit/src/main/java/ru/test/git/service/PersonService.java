package ru.test.git.service;

import ru.test.git.entitties.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonService {

    List<Person> list = new ArrayList<Person>();

    public PersonService() {
        this.list.addAll(Arrays.<Person>asList(new Person("Ann"), new Person("Tom"), new Person("Bob")));
    }

    public List<Person> getAllPersons(){
        return list;
    }

    public void showAllPersons(){
        for (Person p : list){
            System.out.println(p.getName());
        }
    }

}
