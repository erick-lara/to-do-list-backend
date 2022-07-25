package br.com.erick.lara.todolist.usecase.impl;

import br.com.erick.lara.todolist.adapter.controller.dto.request.TaskRequest;
import br.com.erick.lara.todolist.adapter.gateway.db.DatabaseGateway;
import br.com.erick.lara.todolist.domain.Task;
import br.com.erick.lara.todolist.usecase.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private DatabaseGateway databaseGateway;

    @Override
    public void createTask(TaskRequest request) {
        databaseGateway.createTask(request);
    }

    @Override
    public List<Task> findAllTasks() {
        return databaseGateway.findAll();
    }

    @Override
    public Task findTaskById(int id) {
        return databaseGateway.findTaskById(id);
    }

    @Override
    public void updateTask(int id, TaskRequest request) {
        databaseGateway.updateTask(id, request);
    }

    @Override
    public void markTaskCompleted(int id) {
        databaseGateway.markTaskCompleted(id);
    }

    @Override
    public void deleteTask(int id) {
        databaseGateway.deleteTask(id);
    }

    @Override
    public List<Task> findAllActiveTasks() {
        return databaseGateway.findAllActiveTasks();
    }
}
