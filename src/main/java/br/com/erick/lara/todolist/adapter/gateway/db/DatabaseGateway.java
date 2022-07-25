package br.com.erick.lara.todolist.adapter.gateway.db;

import br.com.erick.lara.todolist.adapter.controller.dto.request.TaskRequest;
import br.com.erick.lara.todolist.domain.Task;

import java.util.List;

public interface DatabaseGateway {

    void createTask(TaskRequest request);
    List<Task> findAll();
    Task findTaskById(int id);
    void updateTask(int id, TaskRequest request);
    void markTaskCompleted(int id);
    List<Task> findAllActiveTasks();
    void deleteTask(int id);
}
