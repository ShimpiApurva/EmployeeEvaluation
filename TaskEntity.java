package com.example.demo;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tasks")
public class TaskEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    // Relationship to Employee entity
	    @ManyToOne
	    @JoinColumn(name = "employee_id", nullable = false)
	    private EmployeeEntity employee;

	    @Column(name = "title", nullable = false, length = 255)
	    private String title;

	    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
	    private String description;

	    @Column(name = "due_date")
	    @Temporal(TemporalType.DATE)
	    private Date dueDate;

	    @Column(name = "status", nullable = false, length = 50)
	    private String status;

	    @Column(name = "assigned_by", nullable = false, length = 255)
	    private String assignedBy;

	    // Getters and Setters

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public EmployeeEntity getEmployee() {
	        return employee;
	    }

	    public void setEmployee(EmployeeEntity employee) {
	        this.employee = employee;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public Date getDueDate() {
	        return dueDate;
	    }

	    public void setDueDate(Date dueDate) {
	        this.dueDate = dueDate;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public String getAssignedBy() {
	        return assignedBy;
	    }

	    public void setAssignedBy(String assignedBy) {
	        this.assignedBy = assignedBy;
	    }
}
