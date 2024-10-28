package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;

public class EmployeeDashboardController {
	@GetMapping("/employee/dashboard")
    public String showDashboard() {
        return "employee-dashboard";  // Ensure admin-dashboard.html is in the templates folder
    }
}
