package com.puhj.springbootdemo.service;

import com.puhj.springbootdemo.entity.Person;

import java.util.List;

public interface PersonService {
    void add(Person person);
    void remove(Integer id);
    void edit(Person person);
    Person get(Integer id);
    List<Person> getAll();
}
