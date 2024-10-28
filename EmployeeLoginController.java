package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeLoginController {
	
	@Autowired
    private EmployeeRepo employeeRepository;

    @GetMapping("/employee/login")
    public String showLoginForm() {
        return "Employee_Login";  // Thymeleaf will render employee-login.html
    }

    @PostMapping("/employee/login")
    public ModelAndView handleLogin(@RequestParam String username, @RequestParam String password, HttpSession session) {
        EmployeeEntity employee = employeeRepository.findByUsername(username);

        // If employee not found, redirect to registration page
        if (employee == null) {
            return new ModelAndView("redirect:/employee/register");
        }

        // If password is incorrect, show error message
        if (!password.equals(employee.getPassword())) {
            return new ModelAndView("Employee_Login", "error", "Invalid credentials");
        }

        // Store the employee object in the session after successful login
        session.setAttribute("loggedInEmployee", employee);

        // Pass the employee's name to the dashboard
        ModelAndView modelAndView = new ModelAndView("employee-dashboard");
        modelAndView.addObject("employeeName", employee.getFirstName());  // Assuming employee entity has a getFirstName method

        return modelAndView;
    }

    // Show employee dashboard
    @GetMapping("/employee/dashboard")
    public ModelAndView showDashboard(HttpSession session) {
        EmployeeEntity loggedInEmployee = (EmployeeEntity) session.getAttribute("loggedInEmployee");

        // Check if the employee is logged in
        if (loggedInEmployee == null) {
            return new ModelAndView("redirect:/employee/login"); // Redirect to login if not logged in
        }

        ModelAndView modelAndView = new ModelAndView("employee-dashboard");
        modelAndView.addObject("employeeName", loggedInEmployee.getFirstName());  // Pass employee name to the view
        return modelAndView;
    }
//	 @Autowired
//	    private EmployeeRepo employeeRepository;
//
//	    @GetMapping("/employee/login")
//	    public String showLoginForm() {
//	        return "Employee_Login";  // Thymeleaf will render employee-login.html
//	    }
//	    @PostMapping("/employee/login")
//	    public ModelAndView handleLogin(@RequestParam String username, @RequestParam String password) {
//	        EmployeeEntity employee = employeeRepository.findByUsername(username);
//
//	        // If employee not found, redirect to registration page
//	        if (employee == null) {
//	            return new ModelAndView("redirect:/employee/register");
//	        }
//
//	        // If password is incorrect, show error message
//	        if (!password.equals(employee.getPassword())) {
//	            return new ModelAndView("Employee_Login", "error", "Invalid credentials");
//	        }
//
//	        session.setAttribute("loggedInEmployee", employee);
//	        // Pass the employee's name to the dashboard
//	        ModelAndView modelAndView = new ModelAndView("employee-dashboard");
//	        modelAndView.addObject("employeeName", employee.getFirstName());  // Assuming employee entity has a getFirstName method
//
//	        return modelAndView;
//	    }
//
//	    // Show employee dashboard
//	    @GetMapping("/employee/dashboard")
//	    public ModelAndView showDashboard(HttpSession session) {
//	        EmployeeEntity loggedInEmployee = (EmployeeEntity) session.getAttribute("loggedInEmployee");
//
//	        // Check if the employee is logged in
//	        if (loggedInEmployee == null) {
//	            return new ModelAndView("redirect:/employee/login"); // Redirect to login if not logged in
//	        }
//
//	        ModelAndView modelAndView = new ModelAndView("employee-dashboard");
//	        modelAndView.addObject("employeeName", loggedInEmployee.getFirstName());  // Pass employee name to the view
//	        return modelAndView;
//	    }

//	    @PostMapping("/employee/login")
//	    public ModelAndView handleLogin(@RequestParam String username, @RequestParam String password) {
//	        EmployeeEntity employee = employeeRepository.findByUsername(username);
//
//	        if (employee == null) {
//	            return new ModelAndView("redirect:/employee/register");  // Redirect to registration if employee not found
//	        }
//
//	        if (!password.equals(employee.getPassword())) {
//	            return new ModelAndView("Employee_Login", "error", "Invalid credentials");  // Display error on login page
//	        }
//
//	        return new ModelAndView("redirect:/employee/dashboard");  // Redirect to dashboard if login is successful
//	    }
//
//	    
//	    @GetMapping("/employee/dashboard")
//	    public String showDashboard() {
//	        return "employee-dashboard";  // Render the employee dashboard after successful login
//	    }
	    
}
