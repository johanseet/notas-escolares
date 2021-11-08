package com.johanseet.notasescolares.repository.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
public class Student {
    private @Id @GeneratedValue Long id;
    private String name;
    private String lastname;
    private int age;
    private String schoolGrade;

    public Student(String name, String lastname, int age, String schoolGrade) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.schoolGrade = schoolGrade;
    }
}
