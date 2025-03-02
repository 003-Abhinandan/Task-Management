package com.taskmanager.controller.admin;

import com.taskmanager.dto.TaskDTO;
import com.taskmanager.services.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
/*
  Enables a frontend (e.g., React, Angular, Vue) hosted on a different domain/port to make API calls to the backend.
  Prevents CORS errors when making cross-origin requests.
  During development, when the frontend and backend are on different ports (e.g., React on localhost:3000, Spring Boot on localhost:8080).
  In production, never use "*", as it can expose your API to security risks.
*/
@CrossOrigin("*")
public class AdminController {
      private final AdminService adminService;

      @GetMapping("/users")
      public ResponseEntity<?> getUsers(){
          return ResponseEntity.ok(adminService.getUsers());
      }

      @PostMapping("/task")
      public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO){
         TaskDTO createdTaskDTO = adminService.createTask(taskDTO);
         if(createdTaskDTO == null )return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
         return ResponseEntity.status(HttpStatus.CREATED).body(createdTaskDTO);
      }

      @GetMapping("/tasks")
      public ResponseEntity<?> getAllTasks(){
          return ResponseEntity.ok(adminService.getAllTasks());
      }

      @DeleteMapping("/task/{id}")
      public ResponseEntity<Void> deleteTask(@PathVariable Long id){
          adminService.deleteTask(id);
          return ResponseEntity.ok(null);
      }

      @GetMapping("/task/{id}")
      public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id){
          return ResponseEntity.ok(adminService.getTaskById(id));
      }

    @PutMapping("/task/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        TaskDTO updatedTask = adminService.updateTask(id, taskDTO);
        if (updatedTask == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatedTask);
    }

    @GetMapping("/tasks/search/{title}")
    public ResponseEntity<List<TaskDTO>> searchTask(@PathVariable String title){
          return ResponseEntity.ok(adminService.searchTaskByTitle(title));
    }



}
