package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class TaskController {
	 @Autowired
	    private TaskService taskService;

	    @GetMapping("/tasks")
	    public ResponseEntity<List<TaskEntity>> getAssignedTasks(@RequestParam String username) {
	        List<TaskEntity> tasks = taskService.getTasksForEmployee(username);
	        return new ResponseEntity<>(tasks, HttpStatus.OK);
	    }
}
