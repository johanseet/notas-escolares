package com.johanseet.notasescolares.controller;

import com.johanseet.notasescolares.exception.StudentNotFoundException;
import com.johanseet.notasescolares.repository.StudentRepository;
import com.johanseet.notasescolares.repository.entities.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/Student")
    List<Student> all() {
        return studentRepository.findAll();
    }

    @PostMapping("/Student")
    Student newStudent(@RequestBody Student newStudent) {
        return studentRepository.save(newStudent);
    }

    @GetMapping("/Student/{id}")
    Student one(@PathVariable Long id) {

        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @PutMapping("/Student/{id}")
    Student replaceStudent(@RequestBody Student newStudent, @PathVariable Long id) {

        return studentRepository.findById(id)
                .map(Student -> {
                    Student.setName(newStudent.getName());
                    Student.setLastname(newStudent.getLastname());
                    Student.setAge(newStudent.getAge());
                    Student.setSchoolGrade(newStudent.getSchoolGrade());
                    return studentRepository.save(Student);
                })
                .orElseGet(() -> {
                    newStudent.setId(id);
                    return studentRepository.save(newStudent);
                });
    }

    @DeleteMapping("/Student/{id}")
    void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}
