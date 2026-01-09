package com.example.emp_management.repository;
import com.example.emp_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeRepository extends JpaRepository <Employee,Long>{
}
