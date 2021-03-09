package com.example.econstudio.services;

import com.example.econstudio.models.Course;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {

    List<Course> courses = new ArrayList<>();
    @GetMapping("/api/course")
    public List<Course> findAllCourses() {
        return courses;
    }
}
