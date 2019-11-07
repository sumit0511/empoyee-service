package com.abn.dev.employeeservices.repository.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String empName;
    private int age;
    private String emailId;

}
