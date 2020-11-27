package com.puhj.springbootdemo.api;

import com.puhj.springbootdemo.entity.Dept;
import com.puhj.springbootdemo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*该controller主要演示restful接口风格，get，post，put，delete四种请求的写法*/
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

    @PostMapping("/add")
    public void add(Dept dept) {
        deptService.add(dept);
    }

    @PutMapping("/edit")
    public void edit(Dept dept) {
        deptService.edit(dept);
    }

    @DeleteMapping("/remove")
    public void remove(Integer id) {
        deptService.remove(id);
    }

}
