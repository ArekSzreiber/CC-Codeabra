package com.codeabra.controllers;

import com.codeabra.entities.Role;
import com.codeabra.entities.Student;
import com.codeabra.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("followers", studentService.findAllByRole(Role.FOLLOWER));
        model.addAttribute("leaders", studentService.findAllByRole(Role.LEADER));
        return "students/list";
    }

    @GetMapping("/students/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("roles", Role.values());
        return "students/add";
    }

    @PostMapping("/students")
    public String addNewStudent(@Valid @ModelAttribute Student student,
                                       BindingResult result,
                                       Model model) {

        if (result.hasErrors()) {
            //to retain roles dropdown after attempt to send form with not valid data
            model.addAttribute("roles", Role.values());
            return "students/add";
        } else {
            studentService.save(student);
            return "redirect:/students";
        }
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.delete(id);
        return "redirect:/students";
    }

}
