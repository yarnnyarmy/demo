package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentServices studentServices;

    @Autowired
    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }


    @GetMapping
    public List<Student> getStudents() {
        return studentServices.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentServices.getStudents(student);
    }

    @DeleteMapping(path = {"{studentId}"})

    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentServices.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")

    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {
        studentServices.updateStudent(studentId, name, email);
    }
}