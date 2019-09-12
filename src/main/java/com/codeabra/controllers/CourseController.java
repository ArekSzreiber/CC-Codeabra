package com.codeabra.controllers;

import com.codeabra.entities.Course;
import com.codeabra.entities.Time;
import com.codeabra.entities.Weekday;
import com.codeabra.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CourseController {

    private CourseRepository courseRepository;

    @Autowired
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/courses")
    public String showAllCourses(Model theModel) {
        List<Course> allCourses = courseRepository.findAll();
        theModel.addAttribute("courses", allCourses);
        return "courses/courses-list";
    }


    @GetMapping("/courses/add")
    public String showAddCourseForm(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("weekdays", Weekday.values());
        model.addAttribute("hours", Time.values());
        return "courses/courses-form";
    }

    @PostMapping("/courses/add")
    public String addNewCourse(@Valid @ModelAttribute("course") Course course,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/courses/add";
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
    @DeleteMapping("/courses/delete")
    public String deleteCourse(@RequestParam("courseToDeleteId") int courseId) {
        courseRepository.deleteById(courseId);
        return "redirect:/courses";
    }


}
