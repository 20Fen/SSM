package cn.it.service.impl;

import cn.it.dao.StudentDao;
import cn.it.domain.Student;
import cn.it.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private RedisTemplate redisTemplate;
    public List<Student> findAll() {

        List<Student> all =studentDao.findAll();
        redisTemplate.boundHashOps("a").put("d",all);
        List<Student> a = (List<Student>) redisTemplate.boundHashOps("a").get(all);
        System.out.println(a);
        return a;
    }
}
