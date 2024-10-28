package com.example.demo;

import java.util.List;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import ch.qos.logback.core.model.Model;

@Controller
public class AdminFunctionsController {
	@Autowired
    private EmployeeRepo employeeRepository;
	
	@Autowired
    private EmployeeService employeeService;

    @GetMapping("/admin/employee-management")
    public String employeeManagement(Model model) {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "employee-management"; // HTML template to display employee management page
    }
    
    
    //delete -employee
    @DeleteMapping("/admin/delete-employee/{id}")
    public String deleteEmployee(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        employeeRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Employee deleted successfully!");
        return "redirect:/admin/dashboard";
    }
    @PostMapping("/update-employee")
    public String updateEmployee(@ModelAttribute EmployeeEntity employee, RedirectAttributes redirectAttributes) {
        try {
            employeeService.updateEmployee(employee);
            redirectAttributes.addFlashAttribute("message", "Employee updated successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error updating employee: " + e.getMessage());
        }
        return "redirect:/admin/dashboard";
    }
    
    
    
    
    
    

	 @GetMapping("/admin/assigned-task")
	    public String assignedTask() {
	        return "assigned-task";  // Create performance-analysis.html
	    }

	    @GetMapping("/admin/performance-analysis")
	    public String performanceAnalysis() {
	        return "performance-analysis";  // Create performance-analysis.html
	    }

	    @GetMapping("/admin/appraisal-management")
	    public String appraisalManagement() {
	        return "appraisal-management";  // Create appraisal-management.html
	    }

	    @GetMapping("/admin/leave-approval")
	    public String leaveApproval() {
	        return "leave-approval";  // Create leave-approval.html
	    }

	    @GetMapping("/admin/logout")
	    public String logout() {
	        // Handle logout logic here
	        return "redirect:/admin/login";  // Redirect back to login after logout
	    }
}
