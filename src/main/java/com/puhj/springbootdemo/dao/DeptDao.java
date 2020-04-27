package com.puhj.springbootdemo.dao;

import com.puhj.springbootdemo.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 该dao使用mapper文件的方式操作数据库，须在dao接口上加@Mapper注解、application.yml配置文件中配置相关mybatis
 * 实体类和mapper文件路径以及在springboot应用启动类上加上@MapperScan("com.puhj.springbootdemo.dao")注解，告诉springboot
 * 扫描到接口的路径
 */
@Mapper
@Repository("deptDao")
public interface DeptDao {
    void insert(Dept dept);
    void delete(Integer id);
    void update(Dept dept);
    Dept select(Integer id);
    List<Dept> selectAll();
}
