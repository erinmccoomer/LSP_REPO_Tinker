package org.howard.edu.lspfinal.question2;

/**
 * Exception thrown when a task with the specified name is not found.
 */
public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(String message) {
        super(message);
    }
}