package com.samplebpm.workflowservice.service;

import com.samplebpm.workflowservice.domain.ProcessDefinition;
import com.samplebpm.workflowservice.domain.ProcessInstance;
import com.samplebpm.workflowservice.domain.Task;
import com.samplebpm.workflowservice.repository.InMemoryProcessRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WorkflowServiceTest {
    private WorkflowService workflowService;
    private InMemoryProcessRepository repo;

    @BeforeEach
    public void setup() {
        repo = new InMemoryProcessRepository();
        workflowService = new WorkflowService(repo);
    }

    @Test
    public void start_createsInstanceWithTasks() {
        ProcessDefinition def = new ProcessDefinition("def-1", "Simple", List.of("taskA", "taskB"));
        ProcessInstance instance = workflowService.start(def);

        assertNotNull(instance.getId());
        assertEquals(def.getId(), instance.getDefinitionId());
        assertEquals(2, instance.getTasks().size());
        assertEquals(ProcessInstance.Status.RUNNING, instance.getStatus());
    }

    @Test
    public void completingTasks_advancesInstanceToCompleted() {
        ProcessDefinition def = new ProcessDefinition("def-2", "Flow", List.of("t1", "t2"));
        ProcessInstance instance = workflowService.start(def);

        String instanceId = instance.getId();
        Task first = instance.getTasks().get(0);
        Task second = instance.getTasks().get(1);

        workflowService.completeTask(instanceId, first.getId());
        assertEquals(ProcessInstance.Status.RUNNING, repo.findById(instanceId).getStatus());

        workflowService.completeTask(instanceId, second.getId());
        assertEquals(ProcessInstance.Status.COMPLETED, repo.findById(instanceId).getStatus());
    }

    @Test
    public void completeTask_invalidInstance_throws() {
        assertThrows(IllegalArgumentException.class, () -> workflowService.completeTask("nope", "t"));
    }
}
