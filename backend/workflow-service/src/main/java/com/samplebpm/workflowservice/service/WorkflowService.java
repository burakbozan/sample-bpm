package com.samplebpm.workflowservice.service;

import com.samplebpm.workflowservice.domain.ProcessDefinition;
import com.samplebpm.workflowservice.domain.ProcessInstance;
import com.samplebpm.workflowservice.domain.Task;
import com.samplebpm.workflowservice.repository.InMemoryProcessRepository;

import java.util.UUID;

public class WorkflowService {
    private final InMemoryProcessRepository repository;

    public WorkflowService(InMemoryProcessRepository repository) {
        this.repository = repository;
    }

    public ProcessInstance start(ProcessDefinition definition) {
        String instanceId = UUID.randomUUID().toString();
        ProcessInstance instance = new ProcessInstance(instanceId, definition.getId(), definition.getTaskKeys());
        repository.save(instance);
        return instance;
    }

    public void completeTask(String instanceId, String taskId) {
        ProcessInstance instance = repository.findById(instanceId);
        if (instance == null) throw new IllegalArgumentException("Instance not found: " + instanceId);
        Task task = instance.findTaskById(taskId);
        if (task == null) throw new IllegalArgumentException("Task not found: " + taskId);
        task.setStatus(Task.Status.COMPLETED);
        if (instance.allTasksCompleted()) {
            instance.setStatus(ProcessInstance.Status.COMPLETED);
        }
        repository.save(instance);
    }

    public ProcessInstance getInstance(String id) {
        return repository.findById(id);
    }
}
