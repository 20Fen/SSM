package cn.it.controller;

import cn.it.domain.Student;
import cn.it.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/findAll")
    public String findAll(Map map){

        List<Student> all = studentService.findAll();
//        Map map=new HashMap();
        map.put("students",all);
//        model.addAttribute("students",all);
        return "student";
    }
}
