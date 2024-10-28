package com.example.demo;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "performance_reviews")
public class PerformanceReviewEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String criteria;

	    @Column(nullable = false)
	    private int rating;

	    @Column(nullable = true)
	    private String comments;

	    @Column(name = "review_date", nullable = false)
	    @Temporal(TemporalType.DATE)
	    private Date reviewDate;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "employee_id", nullable = false)
	    private PerformanceReviewEntity employee;

	    // Constructors
	    public PerformanceReviewEntity() {
	    }

	    public PerformanceReviewEntity(String criteria, int rating, String comments, Date reviewDate, PerformanceReviewEntity employee) {
	        this.criteria = criteria;
	        this.rating = rating;
	        this.comments = comments;
	        this.reviewDate = reviewDate;
	        this.employee = employee;
	    }

	    // Getters and Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getCriteria() {
	        return criteria;
	    }

	    public void setCriteria(String criteria) {
	        this.criteria = criteria;
	    }

	    public int getRating() {
	        return rating;
	    }

	    public void setRating(int rating) {
	        this.rating = rating;
	    }

	    public String getComments() {
	        return comments;
	    }

	    public void setComments(String comments) {
	        this.comments = comments;
	    }

	    public Date getReviewDate() {
	        return reviewDate;
	    }

	    public void setReviewDate(Date reviewDate) {
	        this.reviewDate = reviewDate;
	    }

	    public PerformanceReviewEntity getEmployee() {
	        return employee;
	    }

	    public void setEmployee(PerformanceReviewEntity employee) {
	        this.employee = employee;
	    }
}
