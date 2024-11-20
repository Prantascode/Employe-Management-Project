package com.pranta.Em_project.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranta.Em_project.Employee.Employee;
import com.pranta.Em_project.Entity.EmployeeEntity;
import com.pranta.Em_project.Repository.EmployeeRepository;


@Service
public class EmployeeSerivceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        
        employeeRepository.save(employeeEntity);
       
        return "Save Succesfully";
    }
    @Override
    public Employee readEmployee(Long id) {
    EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
    Employee employee = new Employee();
    BeanUtils.copyProperties(employeeEntity,employee);
        return employee;
    }

    @Override
    public List<Employee> readEmployees() {
        List<EmployeeEntity> employeesList = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();

        for (EmployeeEntity employeeEntity : employeesList) {
            Employee emp = new Employee();
            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setEmail(employeeEntity.getEmail());
            emp.setPhone(employeeEntity.getPhone());

            employees.add(emp);
        }
       return employees;
    }

   @Override
    public boolean deleteEmployee(Long id) {
       // employees.remove(id);
       EmployeeEntity emp = employeeRepository.findById(id).get();
       employeeRepository.delete(emp);
        return true;
       
    }

@Override
public String updateEmployee(Long id, Employee employee) {
    EmployeeEntity exestingEmployee = employeeRepository.findById(id).get();
    exestingEmployee.setEmail(employee.getEmail());
    exestingEmployee.setName(employee.getName());
    exestingEmployee.setPhone(employee.getPhone());

    employeeRepository.save(exestingEmployee);

   return "Update Successfully";
}

}