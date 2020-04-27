package com.puhj.springbootdemo.api;

import com.puhj.springbootdemo.entity.Dept;
import com.puhj.springbootdemo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("deptApi")
@RequestMapping("/dept")
public class DeptApi {

    @Autowired
    private DeptService deptService;

    @GetMapping("/list")
    public List<Dept> getAll() {
        return deptService.getAll();
    }

    @GetMapping("/{id}")
    public Dept get(@PathVariable("id") Integer id) {
        return deptService.get(id);
    }
}
