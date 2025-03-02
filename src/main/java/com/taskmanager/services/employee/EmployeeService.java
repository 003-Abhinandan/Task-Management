package com.taskmanager.services.employee;

import com.taskmanager.dto.TaskDTO;

import java.util.List;

public interface EmployeeService {
   List<TaskDTO> getTaskByUserId();
}
