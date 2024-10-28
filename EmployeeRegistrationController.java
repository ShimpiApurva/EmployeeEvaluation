package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller  // Use @Controller for HTML views; if returning JSON, use @RestController
public class EmployeeRegistrationController {

	@Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/register")
    public String showRegistrationForm() {
        return "EmployeeRegistration";  // Thymeleaf will render employee-registration.html
    }

    @PostMapping("/employee/register")
    public ModelAndView handleRegistration(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String dateOfBirth,
            @RequestParam String address,
            @RequestParam String mobileNumber,
            @RequestParam String department,
            @RequestParam String email, 
            @RequestParam String username,
            @RequestParam String password) {

        try {
            employeeService.registerEmployee(firstName, lastName, dateOfBirth, address, mobileNumber, department,email,username, password);
            return new ModelAndView("redirect:/employee/login");  // Redirect to login page after successful registration
        } catch (IllegalStateException e) {
            return new ModelAndView("EmployeeRegistration", "error", e.getMessage());
        }
    }
}
