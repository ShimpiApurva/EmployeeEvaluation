package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
	@Autowired
    private TaskRepo taskRepository;

    @Autowired
    private EmployeeRepo employeeRepository;  // Add this to access employee data

    public List<TaskEntity> getTasksForEmployee(String username) {
        // Assuming employee_id is fetched from username via EmployeeRepository
        EmployeeEntity employee = employeeRepository.findByUsername(username);
        if (employee != null) {
            return taskRepository.findByEmployeeId(employee.getId());
        } else {
            throw new RuntimeException("Employee not found with username: " + username);
        }
    }
}
