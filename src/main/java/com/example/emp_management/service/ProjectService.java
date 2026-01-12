package com.example.emp_management.service;

import com.example.emp_management.entity.Department;
import com.example.emp_management.entity.Project;
import com.example.emp_management.repository.DepartmentRepository;
import com.example.emp_management.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final DepartmentRepository departmentRepository;

    public ProjectService(ProjectRepository projectRepository,
                          DepartmentRepository departmentRepository) {
        this.projectRepository = projectRepository;
        this.departmentRepository = departmentRepository;
    }


    public Project createProject(Project project) {
        Long deptId = project.getDepartment().getId();

        Department dept = departmentRepository.findById(deptId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        project.setDepartment(dept);
        return projectRepository.save(project);
    }


    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }


    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
    }


    public Project updateProject(Long id, Project projectDetails) {
        Project project = getProjectById(id);

        project.setName(projectDetails.getName());

        if (projectDetails.getDepartment() != null) {
            Long deptId = projectDetails.getDepartment().getId();
            Department dept = departmentRepository.findById(deptId)
                    .orElseThrow(() -> new RuntimeException("Department not found"));
            project.setDepartment(dept);
        }

        return projectRepository.save(project);
    }

    // DELETE
    public void deleteProject(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new RuntimeException("Project not found");
        }
        projectRepository.deleteById(id);
    }
}
