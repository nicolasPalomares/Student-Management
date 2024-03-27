package com.mycompany.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.domain.Assignment;

/** 
 * DAO interface for handling Assignment entities.
 * Extends JpaRepository to inherit basic CRUD operations for Assignment entities.
 */

public interface AssignmentDao extends JpaRepository<Assignment, Long> {
	
	/** 
	 * List of all assignments in the database ordered by the student's surname (student registered to the assignment) in ascending order.
	 */
	List<Assignment> findAllByOrderByStudentSurnameAsc();
	
}
