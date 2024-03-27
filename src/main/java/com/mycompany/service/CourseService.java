package com.mycompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.dao.CourseDao;
import com.mycompany.domain.Course;

/** 
 * Implementation of the iService interface for Course entity CRUD operations.
 * Sets the generic type of the interface to Course.
 */

@Service
public class CourseService implements iService<Course> {

	@Autowired
	private CourseDao courseDao;
	
	/** 
	 * Transactional method in read-only mode.
	 * @return List of all courses in the database.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Course> listEntity() {
		return (List<Course>) courseDao.findAll();
	}

	/** 
	 * Transactional method in read-only mode.
	 * @return A course from the database specified with an ID, or null if not found.
	 */
	@Override
	@Transactional(readOnly = true)
	public Course findEntity(Course course) {
		return courseDao.findById(course.getIdCourse()).orElse(null);
	}

	/** 
	 * Transactional method.
	 * Saves a new course entity or updates an existing one.
	 */
	@Override
	@Transactional
	public void saveEntity(Course course) {
		courseDao.save(course);
	}

	/** 
	 * Transactional method.
	 * Deletes a course in the database.
	 */
	@Override
	@Transactional
	public void deleteEntity(Course course) {
		courseDao.delete(course);
	}

}
