package com.puhj.springbootdemo.dao;

import com.puhj.springbootdemo.entity.Person;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("personDao")
public interface PersonDao {

    @Insert("insert into person() values(#{id}, #{username},#{email},#{gender},#{deptId})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    void insert(Person person);

    @Delete("delete from person where id = #{id}")
    void delete(Integer id);

    @Update("update person set username=#{username}, email = #{email},gender = #{gender}, dept_id = #{deptId} where id = #{id}")
    void update(Person person);

    @Select("select * from person where id = #{id}")
    Person select(Integer id);

    @Select("select * from person")
    List<Person> selectAll();
}
