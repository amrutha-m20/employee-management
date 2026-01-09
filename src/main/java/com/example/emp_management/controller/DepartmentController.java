package com.example.emp_management.controller;
import com.example.emp_management.entity.Department;
import com.example.emp_management.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*@RestController = @Controller + @ResponseBody → tells Spring this class handles HTTP requests and returns the response body directly (usually JSON), instead of rendering a template or view.
 */
//@Valid on a controller parameter tells Spring to check all validation annotations on that object.
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService service;
    public DepartmentController(DepartmentService service){
        this.service=service;
    }
    @PostMapping
    public ResponseEntity<Department> createDepartment(@Valid @RequestBody Department department){
        return ResponseEntity.ok(service.createDepartment(department));
    }
    @GetMapping
    public List<Department> getAllDepartments(){
        return service.getAllDepartments();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id){
        return service.getDepartmentById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @Valid@RequestBody Department department){
        return ResponseEntity.ok(service.updateDepartment(id, department));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id){
        boolean deleted = service.deleteDepartment(id);
        if(!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
