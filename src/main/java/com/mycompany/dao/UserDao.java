package com.mycompany.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.domain.UserProgram;

/** 
 * DAO interface for handling user authentication entities (UserProgram entity).
 * Extends JpaRepository to inherit basic CRUD operations for UserProgram entities.
 */

public interface UserDao extends JpaRepository<UserProgram, Long> {
	
	/** 
	 * @return A user entity by username.
	 */
	UserProgram findByUsername(String username);

}
