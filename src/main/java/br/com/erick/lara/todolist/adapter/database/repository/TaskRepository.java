package br.com.erick.lara.todolist.adapter.database.repository;

import br.com.erick.lara.todolist.adapter.database.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

    List<TaskEntity> findAllByIsFinishedFalse();
}
