package com.mycompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.dao.StudentDao;
import com.mycompany.domain.Student;

/** 
 * Implementation of the iService interface for Student entity CRUD operations.
 * Sets the generic type of the interface to Student.
 */

@Service
public class StudentService implements iService<Student> {
	
	@Autowired
	private StudentDao studentDao;

	/** 
	 * Transactional method in read-only mode.
	 * @return List of all students in the database. Uses the previously declared method in StudentDao class 'findAllByOrderBySurnameAsc()'.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Student> listEntity() {
		return (List<Student>) studentDao.findAllByOrderBySurnameAsc();
	}

	/** 
	 * Transactional method in read-only mode.
	 * @return A student from the database specified with an ID, or null if not found.
	 */
	@Override
	@Transactional(readOnly = true)
	public Student findEntity(Student student) {
		return studentDao.findById(student.getIdStudent()).orElse(null);
	}

	/** 
	 * Transactional method.
	 * Saves a new student entity or updates an existing one.
	 */
	@Override
	@Transactional
	public void saveEntity(Student student) {
		studentDao.save(student);
	}

	/** 
	 * Transactional method.
	 * Deletes a student in the database.
	 */
	@Override
	@Transactional
	public void deleteEntity(Student student) {
		studentDao.delete(student);
	}

}
