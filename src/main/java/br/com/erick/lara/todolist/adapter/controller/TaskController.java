package br.com.erick.lara.todolist.adapter.controller;

import br.com.erick.lara.todolist.adapter.controller.dto.request.TaskRequest;
import br.com.erick.lara.todolist.domain.Task;
import br.com.erick.lara.todolist.usecase.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Void> createTask(@RequestBody TaskRequest request){
        taskService.createTask(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAll(){
        return ResponseEntity.ok(taskService.findAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findTaskById(@PathVariable int id){
        return ResponseEntity.ok(taskService.findTaskById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTask(@PathVariable int id, @RequestBody TaskRequest request){
        taskService.updateTask(id, request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/complete/{id}")
    public ResponseEntity<Void> markTaskComplete(@PathVariable int id){
        taskService.markTaskCompleted(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/active")
    public ResponseEntity<List<Task>> findAllActiveTasks(){
        return ResponseEntity.ok(taskService.findAllActiveTasks());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id){
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }
}
