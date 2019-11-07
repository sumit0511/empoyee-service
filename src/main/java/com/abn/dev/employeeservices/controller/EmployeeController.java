package com.abn.dev.employeeservices.controller;


import com.abn.dev.employeeservices.Service.EmployeeService;
import com.abn.dev.employeeservices.repository.model.Employee;
import com.abn.dev.employeeservices.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController implements Constant {


    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    private ResponseEntity<?> getAllEmployees() {

        if(employeeService.getAllEmployees()!=null) {
            return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(EMPLOYEE_UNAUTHORIZED, HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/employees/{id}")
    private ResponseEntity<?> getEmployeeById(@PathVariable("id") int id) {

        if(employeeService.getEmployeeById(id)!=null) {
            return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(EMPLOYEE_ID_NOTEXIST, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/employees/{name}")
    private ResponseEntity<?> getEmployeeByName(@PathVariable("name") String name) {

        if(employeeService.getEmployeesByName(name)!=null) {
            return new ResponseEntity<>(employeeService.getEmployeesByName(name), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(EMPLOYEE_NAME_NOTEXIST, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/employees")
    private ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
        employeeService.saveOrUpdate(employee);
        if(employee.getId()!=0) {
            return new ResponseEntity<>(EMPLOYEE_SAVE_SUCCESS, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(EMPLOYEE_DATA_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
