package com.example.agileapi.controller;

import com.example.agileapi.model.Task;
import com.example.agileapi.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/projects/{projectId}/tasks")
public class TaskController {
    private final TaskService service;
    public TaskController(TaskService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Task> create(@PathVariable Long projectId, @RequestBody Task t) { return ResponseEntity.ok(service.save(projectId, t)); }

    @GetMapping
    public ResponseEntity<List<Task>> list(@PathVariable Long projectId) { return ResponseEntity.ok(service.findByProject(projectId)); }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable Long projectId, @PathVariable Long id, @RequestBody Task t) { return ResponseEntity.ok(service.update(id, t)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long projectId, @PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
