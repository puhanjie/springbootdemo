package com.puhj.springbootdemo.controller;

import com.puhj.springbootdemo.entity.Person;
import com.puhj.springbootdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller("indexController")
public class IndexController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public String getAll(ModelMap modelMap) {
        List<Person> personList = personService.getAll();
        modelMap.addAttribute("persons", personList);
        return "index";
    }
}
