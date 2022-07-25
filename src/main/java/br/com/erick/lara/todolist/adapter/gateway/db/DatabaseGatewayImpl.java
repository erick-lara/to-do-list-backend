package br.com.erick.lara.todolist.adapter.gateway.db;

import br.com.erick.lara.todolist.adapter.controller.dto.request.TaskRequest;
import br.com.erick.lara.todolist.adapter.database.entity.TaskEntity;
import br.com.erick.lara.todolist.adapter.database.repository.TaskRepository;
import br.com.erick.lara.todolist.adapter.gateway.mapper.TaskMapper;
import br.com.erick.lara.todolist.domain.Task;
import br.com.erick.lara.todolist.domain.enums.TaskStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DatabaseGatewayImpl implements DatabaseGateway{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void createTask(TaskRequest request) {
        taskRepository.save(TaskMapper.convertRequestToEntity(request));
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll().stream().map(
                TaskMapper::convertEntityToDomain
        ).collect(Collectors.toList());
    }

    @Override
    public Task findTaskById(int id) {
        TaskEntity foundTask = taskRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        return TaskMapper.convertEntityToDomain(foundTask);
    }

    @Override
    public void updateTask(int id, TaskRequest request) {
        TaskEntity foundTask = taskRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        foundTask.setDescription(request.getDescription());
        foundTask.setDateToFinish(request.getDateToFinish());
        taskRepository.save(foundTask);
    }

    @Override
    public void markTaskCompleted(int id) {
        TaskEntity foundTask = taskRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        foundTask.setFinished(true);
        foundTask.setStatus(TaskStatusEnum.FINISHED);
        taskRepository.save(foundTask);
    }

    @Override
    public List<Task> findAllActiveTasks() {
        return taskRepository.findAllByIsFinishedFalse()
                .stream()
                .map(TaskMapper::convertEntityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTask(int id) {
        taskRepository.delete(taskRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new)
        );
    }
}
