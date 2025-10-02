package com.example.agileapi.controller;

import com.example.agileapi.model.Project;
import com.example.agileapi.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectService service;
    public ProjectController(ProjectService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Project> create(@RequestBody Project p) { return ResponseEntity.ok(service.save(p)); }

    @GetMapping
    public ResponseEntity<List<Project>> all() { return ResponseEntity.ok(service.findAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<Project> get(@PathVariable Long id) { return ResponseEntity.ok(service.findById(id)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
