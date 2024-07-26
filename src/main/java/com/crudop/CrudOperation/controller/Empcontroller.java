package com.crudop.CrudOperation.controller;

import com.crudop.CrudOperation.model.Employee;
import com.crudop.CrudOperation.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")

public class Empcontroller {
    @Autowired
    private EmployeeService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee){
        return service.addEmployee(employee) ;
    }
    @GetMapping
    public List<Employee> getEmployee()
    {
        return service.findAllEmployee();
    }

    @GetMapping ("/{empId}")
    public Employee getEmployee(@PathVariable String empId){
        return service.getEmployeeByEmpId(empId);
    }
    @GetMapping ("/empName/{empName}")
    public List<Employee> findEmployeeUsingEmpName(@PathVariable String empName){
        return service.getEmployeeByEmpName(empName);
    }
    @GetMapping ("/salary/{salary}")
    public List<Employee> getEmployeeBySalary(@PathVariable int  salary){
        return service.getEmployeeBySalary(salary);

    }
    @PutMapping
    public Employee modifyEmployee(@RequestBody Employee employee){
        return service.updateEmployee(employee);
    }
    @DeleteMapping("/{empId}")
    public String deleteEmployee(@PathVariable String empId){
        return service.deleteEmployee(empId);
    }



}
