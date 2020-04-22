package com.puhj.springbootdemo.api;

import com.puhj.springbootdemo.entity.Person;
import com.puhj.springbootdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("personApi")
@RequestMapping("/restfulapi")
public class PersonApi {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public List<Person> getAll() {
        return personService.getAll();
    }

    /**
     * 若只需要单个方法放回json数据，则需要在该方法上加@ResponseBody注解
     */
    /*@RequestMapping("/personList")
    @ResponseBody
    public List<Person> getList() {
        return personService.getAll();
    }*/
}
