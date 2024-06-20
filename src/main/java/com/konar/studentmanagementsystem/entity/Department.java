package com.konar.studentmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "deptName")
    private String dept_name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department",
            cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Student> students;

    public void addStudent(Student tempStudent) {
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(tempStudent);
    }

    @Override
    public String toString() {
        return "department{" +
                "id=" + id +
                ", dept_name='" + dept_name + '\'' +
                '}';
    }
}
