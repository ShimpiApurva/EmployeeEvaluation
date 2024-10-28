package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {
    EmployeeEntity findByUsername(String username);  // Custom query method to find employee by username
}