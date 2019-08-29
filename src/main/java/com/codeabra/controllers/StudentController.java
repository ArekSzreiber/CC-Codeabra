package com.codeabra.controllers;

import com.codeabra.entities.Student;
import com.codeabra.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.xml.bind.Binder;
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
//        model.addAttribute("genders", studentService.getGenders());
        return "index";
    }

    @GetMapping("/students/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/students")
    public String processAddingStudent(@Valid @ModelAttribute Student student,
                                       BindingResult result) {
        if (result.hasErrors()) {
            return "add-student";
        } else {
            studentService.save(student);
            return "redirect:/students";
        }
    }

}
