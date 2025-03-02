package com.taskmanager.services.admin;

import com.taskmanager.dto.TaskDTO;
import com.taskmanager.dto.UserDto;
import com.taskmanager.entities.Task;

import java.util.List;

public interface AdminService {
       List<UserDto> getUsers();
       TaskDTO createTask(TaskDTO taskDTO);
       List<TaskDTO> getAllTasks();
       void deleteTask(Long id);
       TaskDTO getTaskById(Long id);
       TaskDTO updateTask(Long id, TaskDTO taskDTO);
       List<TaskDTO>searchTaskByTitle(String title);

}
