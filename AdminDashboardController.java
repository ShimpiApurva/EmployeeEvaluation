package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminDashboardController {
	@GetMapping("/admin/dashboard")
    public String showDashboard() {
        return "admin-dashboard";  // Ensure admin-dashboard.html is in the templates folder
    }
	
//	@GetMapping("/admin/dashboard")
//    public String showDashboard() {
//        return "redirect:/admin/employee-management";  // Redirect to Employee Management as the default view
//    }
}
