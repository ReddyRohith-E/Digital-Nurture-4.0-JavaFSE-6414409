package com.example.springrestdemo.dao.impl;

import com.example.springrestdemo.dao.EmployeeDao;
import com.example.springrestdemo.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private static final Map<Long, Employee> employees = new HashMap<>();
    private static Long nextId = 1L;

    static {
        employees.put(1L, new Employee(1L, "Virat", "Kohli", "virat.kohli@icc.com", "IT", 75000.0));
        employees.put(2L, new Employee(2L, "Joe", "Root", "joe.root@icc.com", "HR", 65000.0));
        employees.put(3L, new Employee(3L, "Kane", "Williamson", "kane.williamson@icc.com", "IT", 80000.0));
        employees.put(4L, new Employee(4L, "Steve", "Smith", "steve.smith@icc.com", "Finance", 70000.0));
        employees.put(5L, new Employee(5L, "Babar", "Azam", "babar.azam@icc.com", "IT", 85000.0));
        nextId = 6L;
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return Optional.ofNullable(employees.get(id));
    }

    @Override
    public List<Employee> findByDepartment(String department) {
        return employees.values().stream()
                .filter(emp -> emp.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }

    @Override
    public Employee save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(nextId++);
        }
        employees.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public void deleteById(Long id) {
        employees.remove(id);
    }
}
