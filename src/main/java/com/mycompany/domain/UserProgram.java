package com.mycompany.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/** 
 * This UserProgram entity class manages users for security and authentication in the program. There are two users created by me in the database,
 * one for USER_ROLE, and another for ADMIN_ROLE:
 * 
 * 		username: user1
 * 		password: userTest001
 *	 	roles: User
 * 
 * 		username: admin1
 * 		password: adminTest001
 * 		roles: User, Admin
 * 
 * Both passwords where encrypted in the com.mycompany.util.EncryptPassword class and then updated in the database. For more information about
 * security, please refer to SecurityConfig class.
 * 
 * @param idUser - The auto increment primary key of UserProgram instances managed inside the database.
 * @param username - Username of the user.
 * @param password - Password of the user;
 * @param roles - List that contains the roles of the user; it's mapped to the "id_user" column of the roles table. An user can have multiple roles.
 */

@Entity
@Data
@Table(name = "user", schema = "public")
public class UserProgram {
	
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long idUser;
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	@OneToMany()
	@JoinColumn(name = "id_user")
	private List<Role> roles;

}
