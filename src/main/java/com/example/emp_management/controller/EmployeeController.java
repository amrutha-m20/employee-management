package com.example.emp_management.controller;
//Imp note points:
//@RestController tells Spring to return the method’s return value as JSON (or other formats) instead of trying to render a view.
//ResponseEntity<T> is a Spring class that represents an HTTP response.
//@PathVariable Long id:Maps part of the URL to a method parameter.
//When the data comes from the URL path, not the request body.
//Common for GET by ID, DELETE by ID, PUT by ID.
/*
Without @RequestBody, you’d have to:
Read the HTTP request body as a string
Parse JSON manually
Extract each field and set it in a Java object
@RequestBody + Spring does all this automatically.
 */
import com.example.emp_management.entity.Employee;
import com.example.emp_management.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService service;
    public EmployeeController(EmployeeService service){
        this.service=service;
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee){
         Employee saved=service.saveEmployee(employee);
         return ResponseEntity.ok(saved);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        return service.getEmployeeById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        Employee updated=service.updateEmployee(id,employee);
        return ResponseEntity.ok(updated);
    }

//   @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
//        service.deleteEmployee(id);
//        return ResponseEntity.noContent().build();
//    }
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
    boolean deleted = service.deleteEmployee(id);
    if(!deleted){
        return ResponseEntity.notFound().build(); // 404 if ID doesn't exist
    }
    return ResponseEntity.noContent().build(); // 204 if deleted
}



}
