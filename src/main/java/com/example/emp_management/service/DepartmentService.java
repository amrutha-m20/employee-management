package com.example.emp_management.service;
import com.example.emp_management.entity.Department;
import com.example.emp_management.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;

    }
    public Department createDepartment(Department department){
        return repository.save(department);

    }
    public List<Department> getAllDepartments(){
        return repository.findAll();
    }
    public Optional<Department> getDepartmentById(Long id){
        return repository.findById(id);
    }
    /*
    Department deptDetails means the parameter is of type Department (your entity, with fields like id, name, location) and deptDetails is just the variable name holding the new department data.
     */
    public Department updateDepartment(Long id, Department deptDetails){
      Department dept=repository.findById(id).orElseThrow();
      dept.setName(deptDetails.getName());
      dept.setLocation(deptDetails.getLocation());
      return repository.save(dept);
    }
    public boolean deleteDepartment(Long id){
        if(!repository.existsById(id)){
            return false;
        }
        repository.deleteById(id);
        return true;
    }

}
