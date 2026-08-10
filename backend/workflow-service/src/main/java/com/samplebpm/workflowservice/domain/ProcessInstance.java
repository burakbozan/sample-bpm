package com.samplebpm.workflowservice.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProcessInstance {
    public enum Status { RUNNING, COMPLETED }

    private final String id;
    private final String definitionId;
    private final List<Task> tasks = new ArrayList<>();
    private Status status = Status.RUNNING;

    public ProcessInstance(String id, String definitionId, List<String> taskKeys) {
        this.id = id;
        this.definitionId = definitionId;
        int counter = 1;
        for (String key : taskKeys) {
            tasks.add(new Task(id + "-t" + counter++, key));
        }
    }

    public String getId() { return id; }
    public String getDefinitionId() { return definitionId; }
    public List<Task> getTasks() { return List.copyOf(tasks); }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public Task findTaskById(String taskId) {
        return tasks.stream().filter(t -> t.getId().equals(taskId)).findFirst().orElse(null);
    }

    public boolean allTasksCompleted() {
        return tasks.stream().allMatch(Task::isCompleted);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessInstance that = (ProcessInstance) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
