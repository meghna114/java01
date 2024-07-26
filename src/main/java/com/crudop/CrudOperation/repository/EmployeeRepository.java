package com.crudop.CrudOperation.repository;

import com.crudop.CrudOperation.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EmployeeRepository  extends MongoRepository <Employee,String> {
    List<Employee> findByEmpName(String empName);
    @Query("{ salary: ?0}")
    List<Employee> getEmployeeBySalary(int salary);
}
