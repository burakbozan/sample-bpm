package com.samplebpm.workflowservice.repository;

import com.samplebpm.workflowservice.domain.ProcessInstance;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryProcessRepository {
    private final Map<String, ProcessInstance> store = new ConcurrentHashMap<>();

    public ProcessInstance save(ProcessInstance instance) {
        store.put(instance.getId(), instance);
        return instance;
    }

    public ProcessInstance findById(String id) {
        return store.get(id);
    }
}
