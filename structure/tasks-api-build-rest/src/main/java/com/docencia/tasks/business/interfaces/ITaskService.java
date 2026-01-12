package com.docencia.tasks.business.interfaces;

import java.util.List;

import com.docencia.tasks.domain.model.Task;

public interface ITaskService {
    Task createTask(Task task);
    List<Task> getTask();
    Task getTaskById(long id);
    Task updateTask(Task task);
    boolean deleteTask(Task task);
}
