package com.crudop.CrudOperation.model;


import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Employee {
    @Id
    private String empId;
    private String empName;
    private String gender;
    private String email;
    private int noOfLeaves;
    private int salary;


}
