package com.samplebpm.workflowservice.domain;

import java.util.Objects;

public class Task {
    public enum Status { PENDING, COMPLETED }

    private final String id;
    private final String key;
    private Status status;
    private String assignee;

    public Task(String id, String key) {
        this.id = id;
        this.key = key;
        this.status = Status.PENDING;
    }

    public String getId() { return id; }
    public String getKey() { return key; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public String getAssignee() { return assignee; }
    public void setAssignee(String assignee) { this.assignee = assignee; }

    public boolean isCompleted() { return status == Status.COMPLETED; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
