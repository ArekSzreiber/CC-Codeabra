package com.codeabra.controllers;

import com.codeabra.entities.Course;
import com.codeabra.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class CourseController {

    private CourseRepository courseRepository;

    @Autowired
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/courses")
    public String showAllCourses(Model theModel) {
        theModel.addAttribute("courses", courseRepository.findAll());
        return "courses/courses-list";
    }


    @GetMapping("/courses/add")
    public String showAddCourseForm(Model model) {
        model.addAttribute("course", new Course());
        return "courses/courses-form";
    }

    @PostMapping("/courses/add")
    public String addNewCourse(@Valid @ModelAttribute("course") Course course,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "courses/courses-form";
        } else {
            courseRepository.save(course);
            return "redirect:/courses";
        }
    }

    //edit Course
    @GetMapping("/courses/edit")
    public String editCourseForm(@RequestParam("id") int courseId,
                                 Model model) {
        Course course = courseRepository.findById(courseId).get();//TODO use Optional (see examples in medicalspring)
        model.addAttribute("course", course);
        return "courses/course-form";
    }

    //delete Course
    @GetMapping("/courses/delete")
    public String deleteCourse(@RequestParam("courseToDeleteId") int courseId) {
        courseRepository.deleteById(courseId);
        return "redirect:/courses";
    }


}
