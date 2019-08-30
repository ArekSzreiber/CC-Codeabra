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

import javax.validation.Valid;
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
        model.addAttribute("ladies", studentService.findAllFemales());
        model.addAttribute("gentlemen", studentService.findAllMales());
        return "students/list";
    }

    @GetMapping("/students/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("genders", Gender.values());
        return "students/add";
    }

    @PostMapping("/students")
    public String addNewStudent(@Valid @ModelAttribute Student student,
                                       BindingResult result,
                                       Model model) {

        if (result.hasErrors()) {
            //to retain gender dropdown after attempt to send form with not valid data
            model.addAttribute("genders", Gender.values());
            return "students/add";
        } else {
            studentService.save(student);
            return "redirect:/students";
        }
    }

}
