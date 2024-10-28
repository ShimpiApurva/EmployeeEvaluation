package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
    private EmployeeRepo employeeRepository;

    public void registerEmployee(String firstName, String lastName, String dateOfBirth, String address, String mobileNumber,String department,String email, String username, String password) {
        // Check if the username already exists
        if (employeeRepository.findByUsername(username) != null) {
            throw new IllegalStateException("Username already exists");
        }

        // Create a new employee entity
        EmployeeEntity employee = new EmployeeEntity(firstName, lastName, dateOfBirth, address, mobileNumber, department, email, username, password);
        
        // Save the employee into the repository (database)
        employeeRepository.save(employee);
    }
    
    public void updateEmployee(EmployeeEntity employee) {
        // Perform validation if needed
        // Example: Check if the employee exists in the database
        Optional<EmployeeEntity> existingEmployee = employeeRepository.findById(employee.getId());

        if (existingEmployee.isPresent()) {
            // Update the employee in the database
            employeeRepository.save(employee);
        } else {
            throw new RuntimeException("Employee not found");
        }
    }
}
