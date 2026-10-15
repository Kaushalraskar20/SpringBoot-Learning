package com.xpert;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    // Display all students
    @GetMapping("/students1")
    public String viewStudents1(Model model) {

        List<Students> list = service.getAllStudents();

        model.addAttribute("students", list);

        return "students";
    }

    // Add student with image
    @PostMapping("/students")
    @ResponseBody
    public Students addStudent(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam("image") MultipartFile imageFile) {

        try {
            return service.saveStudents(name, email, imageFile);

        } catch (Exception e) {
            throw new RuntimeException(
                    "Error saving student: " + e.getMessage());
        }
    }
}