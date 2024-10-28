package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
//import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;


@Controller
public class EmployeeFunctionsController {
	
	
	@GetMapping("/employee/profile-management")
	public String profileManagement(Model model, HttpSession session) {
	    EmployeeEntity loggedInEmployee = (EmployeeEntity) session.getAttribute("loggedInEmployee");

	    if (loggedInEmployee == null) {
	        return "redirect:/employee/login"; // Redirect to login if not logged in
	    }

	    model.addAttribute("employee", loggedInEmployee);
	    return "profile-management"; // Return the profile management template
	}
 
	 @Autowired
	    private EmployeeRepo employeeRepository;
	
	@GetMapping("/employee/manage-profile")
    public String manageProfile(HttpSession session, Model model) {
        EmployeeEntity loggedInEmployee = (EmployeeEntity) session.getAttribute("loggedInEmployee");

        if (loggedInEmployee != null) {
            // Pass the employee data to the edit form
            model.addAttribute("employee", loggedInEmployee);
            return "edit-profile";  // Render edit-profile.html
        } else {
            return "redirect:/employee/login"; // Redirect to login if not found
        }
    }

    @PostMapping("/employee/update-profile")
    public String updateProfile(HttpSession session, EmployeeEntity updatedEmployee) {
        EmployeeEntity loggedInEmployee = (EmployeeEntity) session.getAttribute("loggedInEmployee");

        if (loggedInEmployee != null) {
            // Update the employee entity with the new details
            loggedInEmployee.setFirstName(updatedEmployee.getFirstName());
            loggedInEmployee.setLastName(updatedEmployee.getLastName());
            loggedInEmployee.setDateOfBirth(updatedEmployee.getDateOfBirth());
            loggedInEmployee.setAddress(updatedEmployee.getAddress());
            loggedInEmployee.setMobileNumber(updatedEmployee.getMobileNumber());
            loggedInEmployee.setDepartment(updatedEmployee.getDepartment());
            loggedInEmployee.setEmail(updatedEmployee.getEmail());

            // Save the updated employee information to the database
            employeeRepository.save(loggedInEmployee);

            // Update the session attribute
            session.setAttribute("loggedInEmployee", loggedInEmployee);
        }

        //return "redirect:/employee/profile-management"; // Redirect back to the profile management page
        return "redirect:/employee/dashboard"; 
    }
	
    
    
	
 @GetMapping("/employee/view-assigned-task")
    public String assignedTask() {
        return "view-assigned-task";  // Create performance-analysis.html
    }

    @GetMapping("/employee/performance-dashboard")
    public String performanceDashboard() {
        return "performance-dashboard";  // Create performance-analysis.html
    }
    
    @GetMapping("/employee/task-progress")
    public String taskProgress() {
        return "task-progress";  // Create performance-analysis.html
    }


    @GetMapping("/employee/appraisal-history")
    public String appraisalHistory() {
        return "appraisal-history";  // Create appraisal-management.html
    }

    @GetMapping("/employee/leave-request")
    public String leaveRequest() {
        return "leave-request";  // Create leave-approval.html
    }

    @GetMapping("/employee/logout")
    public String logout(HttpSession session) {
        // Invalidate the session to log out the user
        session.invalidate();
        return "redirect:/employee/login";  // Redirect back to the employee login page
    }
}
