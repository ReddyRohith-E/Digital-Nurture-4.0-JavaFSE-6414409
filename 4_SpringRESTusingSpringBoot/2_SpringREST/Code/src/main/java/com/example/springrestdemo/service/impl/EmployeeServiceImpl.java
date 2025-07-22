package com.example.springrestdemo.service.impl;

import com.example.springrestdemo.dao.EmployeeDao;
import com.example.springrestdemo.model.Employee;
import com.example.springrestdemo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    private final EmployeeDao employeeDao;
    
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    
    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }
    
    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeDao.findById(id);
    }
    
    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeDao.findByDepartment(department);
    }
    
    @Override
    public Employee createEmployee(Employee employee) {
        return employeeDao.save(employee);
    }
    
    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        employee.setId(id);
        return employeeDao.save(employee);
    }
    
    @Override
    public void deleteEmployee(Long id) {
        employeeDao.deleteById(id);
    }
}
