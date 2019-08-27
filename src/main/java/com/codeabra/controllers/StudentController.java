package com.codeabra.controllers;

import com.codeabra.entities.Student;
import com.codeabra.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping({"/", "/students"})
    public String showMain(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        System.out.println(students.toString());
        return "index";
    }

    @GetMapping("students/add")
    public String showAddStudentForm() {
        return "add-student";
    }

    @PostMapping("students/add")
    public String processAddingStudent() {
        //process adding student
        return "index";
    }

}
