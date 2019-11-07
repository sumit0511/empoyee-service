package com.abn.dev.employeeservices.repository.dao;


import com.abn.dev.employeeservices.repository.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAll();
    List<Employee> findByName(String name);
    Employee findById(long id);

}