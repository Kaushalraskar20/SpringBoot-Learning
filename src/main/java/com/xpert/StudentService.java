package com.xpert;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private final String uploadDir = "uploads/";

    public Students saveStudents(String name, String email, MultipartFile imageFile) throws IOException {

        // Ensure upload folder exists
        File dir = new File(uploadDir);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Save the file to the folder
        String filePath = uploadDir + imageFile.getOriginalFilename();

        imageFile.transferTo(new File(filePath));

        // Save the student record to the database
        Students students = new Students();

        students.setName(name);
        students.setEmail(email);
        students.setImagePath(filePath);

        return studentRepository.save(students);
    }

    // Get all students
    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }
}