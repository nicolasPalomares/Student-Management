package com.mycompany.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.mycompany.dao.UserDao;
import com.mycompany.domain.Role;
import com.mycompany.domain.UserProgram;

/** 
 * Service class providing user-related functionality for Spring Security integration.
 * Implements UserDetailsService to facilitate user authentication and authorization.
 */

@Service("userDetailsService")
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;
	
	/** 
	 * Transactional method in read-only mode.
	 * Loads a user by the given username and configures the roles for that user.
	 * @return UserDetails representing the user.
	 * @throws UsernameNotFoundException if the user is not found.
	 */
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserProgram user = userDao.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		var roles = new ArrayList<GrantedAuthority>();
		
		for(Role role : user.getRoles()) {
			roles.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		return new User(user.getUsername(), user.getPassword(), roles);
		
	}

}
