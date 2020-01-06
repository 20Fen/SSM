package cn.it.dao;

import cn.it.domain.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentDao {
    @Select("select * from student")
    public List<Student> findAll();

}
