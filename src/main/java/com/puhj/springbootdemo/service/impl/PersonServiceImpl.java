package com.puhj.springbootdemo.service.impl;

import com.puhj.springbootdemo.dao.PersonDao;
import com.puhj.springbootdemo.entity.Person;
import com.puhj.springbootdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("personServiceImpl")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public void add(Person person) {
        personDao.insert(person);
    }

    @Override
    public void remove(Integer id) {
        personDao.delete(id);
    }

    @Override
    public void edit(Person person) {
        personDao.update(person);
    }

    @Override
    public Person get(Integer id) {
        return personDao.select(id);
    }

    @Override
    public List<Person> getAll() {
        return personDao.selectAll();
    }
}
