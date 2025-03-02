package com.taskmanager.services.employee;

import com.taskmanager.dto.TaskDTO;
import com.taskmanager.entities.Task;
import com.taskmanager.entities.User;
import com.taskmanager.repositories.TaskRepository;
import com.taskmanager.utils.JwtUtil;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
      private final TaskRepository taskRepository;
      private final JwtUtil jwtUtil;


    @Override
    public List<TaskDTO> getTaskByUserId() {
        User user = jwtUtil.getLoggedInUser();
        if (user != null) {
           return taskRepository.findAllByUserId(user.getId())
                    .stream()
                    .sorted(Comparator.comparing(Task::getDueDate).reversed())
                            .map(Task::getTaskDTO)
                    .collect(Collectors.toList());
        }
        throw new EntityNotFoundException("User not found");

    }
}
