package com.codeabra.controllers;

import com.codeabra.entities.Gender;
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
    public String showStudents(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        model.addAttribute("ladies", studentService.findAllFemales());
        model.addAttribute("gentlemen", studentService.findAllMales());
        return "index";
    }

    @GetMapping("/students/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("genders", Gender.values());
        return "add-student";
    }

    @PostMapping("/students")
    public String processAddingStudent(@Valid @ModelAttribute Student student,
                                       BindingResult result,
                                       Model model) {
        //to retain gender dropdown after attempt to send form with not valid data
        model.addAttribute("genders", Gender.values());
        if (result.hasErrors()) {
            return "add-student";
        } else {
            studentService.save(student);
            return "redirect:/students";
        }
    }

}
