package com.codeabra.controller;

import com.codeabra.entity.Course;
import com.codeabra.repository.CourseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CourseController {

    private CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/courses")
    public String findAll(Model theModel) {
        theModel.addAttribute("courses", courseRepository.findAll());
        return "courses/courses-list";
    }

    //add new Course
    @GetMapping("/courses/add-form")
    public String courseAddingForm(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);
        return "courses/courses-form";
    }

    @PostMapping("/courses/add-form")
    public String addNewCourse(
            @Valid @ModelAttribute("course") Course course,
            BindingResult result){
        if (result.hasErrors()){
            return "courses/courses-form";
        } else {
            courseRepository.save(course);
            return "redirect:/courses";
        }
    }

    //edit Course
    @GetMapping("/courses/edit-course")
    public String editCourseForm(@RequestParam("courseToEditId") int courseId,
                                 Model model) {
        Course course = (Course) courseRepository.findById(courseId).get();
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
