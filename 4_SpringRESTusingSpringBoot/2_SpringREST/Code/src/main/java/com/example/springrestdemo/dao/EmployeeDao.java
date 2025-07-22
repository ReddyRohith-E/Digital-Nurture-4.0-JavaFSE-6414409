package com.example.springrestdemo.dao;

import com.example.springrestdemo.model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeDao {
    List<Employee> findAll();
    Optional<Employee> findById(Long id);
    List<Employee> findByDepartment(String department);
    Employee save(Employee employee);
    void deleteById(Long id);
}
