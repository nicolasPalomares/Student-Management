package com.mycompany.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.domain.Course;

/** 
 * DAO interface for handling Course entities.
 * Extends JpaRepository to inherit basic CRUD operations for Course entities.
 */

public interface CourseDao extends JpaRepository<Course, Long> {

}
