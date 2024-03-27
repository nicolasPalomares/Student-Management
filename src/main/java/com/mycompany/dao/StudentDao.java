package com.mycompany.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.domain.Student;

/** 
 * DAO interface for handling Student entities.
 * Extends JpaRepository to inherit basic CRUD operations for Student entities.
 */

public interface StudentDao extends JpaRepository<Student, Long> {
	
	/** 
	 * @return List of all students in the database ordered by surname in ascending order.
	 * */
	List<Student> findAllByOrderBySurnameAsc();

}
