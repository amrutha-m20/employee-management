package com.example.emp_management.service;
import com.example.emp_management.entity.Employee;
import com.example.emp_management.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }
    public Employee saveEmployee(Employee employee){
        return repository.save(employee);
    }
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }
    public Optional<Employee> getEmployeeById(Long id){
        return repository.findById(id);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        return repository.findById(id).map(existing -> {
            existing.setName(employee.getName());
            existing.setEmail(employee.getEmail());
            existing.setDepartment(employee.getDepartment()); // expects Department object
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public boolean deleteEmployee(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }




}
