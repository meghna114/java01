package com.crudop.CrudOperation.services;

import com.crudop.CrudOperation.model.Employee;
import com.crudop.CrudOperation.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    //CRUD Operations -- CREATE , READ, UPDATE, DELETE
    public Employee addEmployee(Employee employee){
        employee.setEmpId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(employee);

    }
    public List<Employee> findAllEmployee()
    {
       return repository.findAll();
    }
    //READ
    public Employee getEmployeeByEmpId(String empId){
        return repository.findById(empId).get();
    }
    public List<Employee> getEmployeeByEmpName(String empName){
        return repository.findByEmpName(empName);
    }
    public List<Employee> getEmployeeBySalary(int salary){
        return repository.getEmployeeBySalary(salary);

    }
    //UPDATE
    public Employee updateEmployee(Employee employeeRequest){
        //get existing doc from db
        Employee existingEmployee= repository.findById(employeeRequest.getEmpId()).get();
        existingEmployee.setNoOfLeaves(employeeRequest.getNoOfLeaves());
        existingEmployee.setEmail(employeeRequest.getEmail());
        existingEmployee.setSalary(employeeRequest.getSalary());
        existingEmployee.setGender(employeeRequest.getGender());
        existingEmployee.setEmpName(employeeRequest.getEmpName());
        return repository.save(existingEmployee);
    }
    //DELETE
    public String deleteEmployee(String empId){
        repository.deleteById(empId);
        return empId + "employee deleted from dashboard";
    }





}
