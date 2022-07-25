package br.com.erick.lara.todolist.adapter.gateway.mapper;

import br.com.erick.lara.todolist.adapter.controller.dto.request.TaskRequest;
import br.com.erick.lara.todolist.adapter.database.entity.TaskEntity;
import br.com.erick.lara.todolist.domain.Task;

public class TaskMapper {

    private TaskMapper() {
        throw new AssertionError("UTILITY CLASS MUST NOT BE INSTANTIATED");
    }

    public static TaskEntity convertRequestToEntity(TaskRequest request){
        return new TaskEntity(request.getDescription(), request.getDateToFinish());
    }

    public static Task convertEntityToDomain(TaskEntity entity){
        return new Task(
                entity.getId(),
                entity.getDescription(),
                entity.getDhInsert(),
                entity.getDateToFinish(),
                entity.getFinished(),
                entity.getStatus()
        );
    }
}
