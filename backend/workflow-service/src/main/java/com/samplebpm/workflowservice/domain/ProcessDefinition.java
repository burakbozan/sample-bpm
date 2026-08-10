package com.samplebpm.workflowservice.domain;

import java.util.List;
import java.util.Objects;

public class ProcessDefinition {
    private final String id;
    private final String name;
    private final List<String> taskKeys;

    public ProcessDefinition(String id, String name, List<String> taskKeys) {
        this.id = id;
        this.name = name;
        this.taskKeys = List.copyOf(taskKeys);
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public List<String> getTaskKeys() { return taskKeys; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessDefinition that = (ProcessDefinition) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
