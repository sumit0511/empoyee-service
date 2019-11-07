package com.abn.dev.employeeservices.Service;

import com.abn.dev.employeeservices.repository.dao.EmployeeRepository;
import com.abn.dev.employeeservices.repository.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<Employee>();
        employeeRepository.findAll().forEach(employee -> employee.add(employee));
        return employees;
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).get();
    }

    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findByName(name);
    }

    public void saveOrUpdate(Employee employee) {
        employeeRepository.save(employee);
    }

}
