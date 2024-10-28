package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
	// Hardcoded admin credentials
    private final String validUsername = "admin";
    private final String validPassword = "admin123";

    @GetMapping("/admin/login")
    public String adminLogin() {
        return "admin-login";  // Serve the login page
    }

    @PostMapping("/admin/login")
    public String handleAdminLogin(@RequestParam String username, @RequestParam String password) {
        // Validate the credentials
        if (validUsername.equals(username) && validPassword.equals(password)) {
            return "redirect:/admin/dashboard";  // Redirect to admin dashboard on success
        } else {
            return "redirect:/admin/login?error";  // Redirect back to login page with error
        }
    }
}
