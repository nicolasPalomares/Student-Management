package com.mycompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.dao.AssignmentDao;
import com.mycompany.domain.Assignment;

/** 
 * Implementation of the iService interface for Assignment entity CRUD operations.
 * Sets the generic type of the interface to Assignment.
 */

@Service
public class AssignmentService implements iService<Assignment> {
	
	@Autowired
	private AssignmentDao assignmentDao;

	/** 
	 * Transactional method in read-only mode.
	 * @return List of all assignments in the database.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Assignment> listEntity() {
		return (List<Assignment>) assignmentDao.findAllByOrderByStudentSurnameAsc();
	}

	/** 
	 * Transactional method in read-only mode.
	 * @return An assignment from the database specified with an ID, or null if not found.
	 */
	@Override
	@Transactional(readOnly = true)
	public Assignment findEntity(Assignment assignment) {
		return assignmentDao.findById(assignment.getIdAssignment()).orElse(null);
	}

	/** 
	 * Transactional method.
	 * Saves a new assignment entity or updates an existing one.
	 */
	@Override
	@Transactional
	public void saveEntity(Assignment assignment) {
		assignmentDao.save(assignment);
	}

	/** 
	 * Transactional method.
	 * Deletes an assignment in the database.
	 */
	@Override
	@Transactional
	public void deleteEntity(Assignment assignment) {
		assignmentDao.delete(assignment);
	}

}
