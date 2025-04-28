package com.test.security.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    //properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rollNo;
    @Column(name = "student_name")
    private String name;
    @Column(name = "student_mark")
    private Integer marks;



  
}
