package com.puhj.springbootdemo.api;

import com.puhj.springbootdemo.entity.Person;
import com.puhj.springbootdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("personApi")
@RequestMapping("/person")
public class PersonApi {

    @Autowired
    private PersonService personService;

    @GetMapping("/list")
    public List<Person> getAll() {
        return personService.getAll();
    }

    @GetMapping("/{id}")
    public Person get(@PathVariable("id") Integer id) {
        return personService.get(id);
    }

    @PostMapping("/add")
    public void add(Person person) {
        personService.add(person);
    }

    @PutMapping("/edit")
    public void edit(Person person) {
        personService.edit(person);
    }

    @DeleteMapping("/remove")
    public void remove(Integer id) {
        personService.remove(id);
    }

//     若只需要单个方法放回json数据，则需要在该方法上加@ResponseBody注解
    /*@RequestMapping("/personList")
    @ResponseBody
    public List<Person> getList() {
        return personService.getAll();
    }*/

}
