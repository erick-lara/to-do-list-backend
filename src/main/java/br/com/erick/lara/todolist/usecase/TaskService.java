package br.com.erick.lara.todolist.usecase;

import br.com.erick.lara.todolist.adapter.controller.dto.request.TaskRequest;
import br.com.erick.lara.todolist.domain.Task;

import java.util.List;

public interface TaskService {
    void createTask(TaskRequest request);
    List<Task> findAllTasks();
    Task findTaskById(int id);
    void updateTask(int id, TaskRequest request);
    void markTaskCompleted(int id);
    void deleteTask(int id);
    List<Task> findAllActiveTasks();
}
