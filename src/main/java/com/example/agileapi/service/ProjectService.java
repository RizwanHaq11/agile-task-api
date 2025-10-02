package com.example.agileapi.service;

import com.example.agileapi.model.Project;
import com.example.agileapi.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository repo;
    public ProjectService(ProjectRepository repo) { this.repo = repo; }
    public Project save(Project p) { return repo.save(p); }
    public List<Project> findAll() { return repo.findAll(); }
    public Project findById(Long id) { return repo.findById(id).orElseThrow(); }
    public void delete(Long id) { repo.deleteById(id); }
}
