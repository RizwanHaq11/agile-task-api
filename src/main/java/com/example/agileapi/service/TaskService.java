package com.example.agileapi.service;

import com.example.agileapi.model.Task;
import com.example.agileapi.model.Project;
import com.example.agileapi.repository.TaskRepository;
import com.example.agileapi.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepo;
    private final ProjectRepository projectRepo;
    public TaskService(TaskRepository tr, ProjectRepository pr) { this.taskRepo = tr; this.projectRepo = pr; }

    public Task save(Long projectId, Task t) {
        Project p = projectRepo.findById(projectId).orElseThrow();
        t.setProject(p);
        return taskRepo.save(t);
    }
    public List<Task> findByProject(Long projectId) { return taskRepo.findByProjectId(projectId); }
    public Task update(Long id, Task t) {
        Task existing = taskRepo.findById(id).orElseThrow();
        existing.setTitle(t.getTitle());
        existing.setDescription(t.getDescription());
        existing.setStatus(t.getStatus());
        return taskRepo.save(existing);
    }
    public void delete(Long id) { taskRepo.deleteById(id); }
}
