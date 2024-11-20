package com.pranta.Em_project.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.pranta.Em_project.Employee.Employee;
import com.pranta.Em_project.Service.EmployeeSerivceImpl;
import com.pranta.Em_project.Service.EmployeeService;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@CrossOrigin("http://localhost:3000/")
public class EmController {
    
    //Dependcy injection
    @Autowired
   EmployeeService employeeService = new EmployeeSerivceImpl();

    @GetMapping("employees")
    public List<Employee>getAllEmployees() {
        return employeeService.readEmployees();
    }
    @GetMapping("employees/{id}")
    public Employee getEmployeesById(@PathVariable Long id) {
        return employeeService.readEmployee(id);
    }
    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
         
    }
    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id){
        if(employeeService.deleteEmployee(id)){
            return "Delete Succesfully";
        }
        return "Not found!";
    }
    @PutMapping("employees/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }
}