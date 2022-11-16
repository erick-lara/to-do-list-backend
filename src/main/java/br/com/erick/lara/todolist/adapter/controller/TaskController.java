package br.com.erick.lara.todolist.adapter.controller;

import br.com.erick.lara.todolist.adapter.controller.dto.request.TaskRequest;
import br.com.erick.lara.todolist.domain.Task;
import br.com.erick.lara.todolist.usecase.TaskService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @ApiOperation(value = "Cria uma nova task.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "")
    })
    @PostMapping
    public ResponseEntity<Void> createTask(@RequestBody TaskRequest request){
        taskService.createTask(request);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Busca todas as tasks registradas.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "")
    })
    @GetMapping
    public ResponseEntity<List<Task>> findAll(){
        return ResponseEntity.ok(taskService.findAllTasks());
    }

    @ApiOperation(value = "Busca a task por um ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Task> findTaskById(@ApiParam @PathVariable int id){
        return ResponseEntity.ok(taskService.findTaskById(id));
    }

    @ApiOperation(value = "Atualiza a task por um ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTask(
            @ApiParam @PathVariable int id,
            @ApiParam @RequestBody TaskRequest request
    ){
        taskService.updateTask(id, request);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Marca uma task como completa por seu ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "")
    })
    @PutMapping("/complete/{id}")
    public ResponseEntity<Void> markTaskComplete(@ApiParam @PathVariable int id){
        taskService.markTaskCompleted(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Busca todas as tasks ativas.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "")
    })
    @GetMapping("/active")
    public ResponseEntity<List<Task>> findAllActiveTasks(){
        return ResponseEntity.ok(taskService.findAllActiveTasks());
    }

    @ApiOperation(value = "Exclui uma task por seu ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@ApiParam @PathVariable int id){
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }
}
