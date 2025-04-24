package org.howard.edu.lspfinal.question2;

import java.util.*;

/**
 * Manages tasks, allowing operations like add, retrieve, update, and grouped printing.
 */
public class TaskManager {
    private Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a new task to the system.
     * @param name unique name of the task
     * @param priority priority value (lower means higher priority)
     * @param status must be "TODO", "IN_PROGRESS", or "DONE"
     * @throws DuplicateTaskException if the task name already exists
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }
        tasks.put(name, new Task(name, priority, status));
    }

    /**
     * Retrieves a task by its name.
     * @param name name of the task
     * @return the Task object
     * @throws TaskNotFoundException if the task doesn't exist
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        if (!tasks.containsKey(name)) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return tasks.get(name);
    }

    /**
     * Updates the status of a given task.
     * @param name name of the task
     * @param newStatus must be "TODO", "IN_PROGRESS", or "DONE"
     * @throws TaskNotFoundException if the task doesn't exist
     */
    public void updateStatus(String name, String newStatus) throws TaskNotFoundException {
        Task task = getTaskByName(name);
        task.setStatus(newStatus);
    }

    /**
     * Prints all tasks grouped by their status.
     */
    public void printTasksGroupedByStatus() {
        System.out.println("Tasks grouped by status:");
        List<String> statuses = Arrays.asList("TODO", "IN_PROGRESS", "DONE");
        for (String status : statuses) {
            System.out.println(status + ":");
            for (Task task : tasks.values()) {
                if (task.getStatus().equals(status)) {
                    System.out.println("  " + task);
                }
            }
        }
    }
}
