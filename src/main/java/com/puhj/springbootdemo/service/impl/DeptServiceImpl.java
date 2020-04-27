package com.puhj.springbootdemo.service.impl;

import com.puhj.springbootdemo.dao.DeptDao;
import com.puhj.springbootdemo.entity.Dept;
import com.puhj.springbootdemo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("deptServiceImpl")
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Transactional
    @Override
    public void add(Dept dept) {
        deptDao.insert(dept);
    }

    /**
     * springboot开启事务的方式：
     * 1.在需要启用事务的service层方法上加上@Transactional注解
     * 2.在springboot启动类上面加上@EnableTransactionManagement注解
     * @param id
     */
    @Transactional
    @Override
    public void remove(Integer id) {
        deptDao.delete(id);
    }

    @Transactional
    @Override
    public void edit(Dept dept) {
        deptDao.update(dept);
    }

    @Override
    public Dept get(Integer id) {
        return deptDao.select(id);
    }

    @Override
    public List<Dept> getAll() {
        return deptDao.selectAll();
    }
}
