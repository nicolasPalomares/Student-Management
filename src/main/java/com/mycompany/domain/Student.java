package com.mycompany.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * This class represents a student entity in the system.
 * @param idStudent - The auto increment primary key of Student instances managed inside the database.
 * @param name - Name of the student.
 * @param surname - Surname of the student.
 * @param address - This parameter of type Address represents the residential address of the student; it's mapped to the "id_address" column in the database table,
 * 					and it is associated with the corresponding Address entity through a many-to-one relationship.
 * @param contact - This parameter of type Contact contains information to contact the student; it's mapped to the "id_contact" column in the database table,
 * 					and it is associated with the corresponding Contact entity through a many-to-one relationship.
 * @param assignments - A list containing instances of Assignment, mapped to the "student" column in the assignment table. Since is annotated with one-to-many,
 * 						an instance of Student can be related multiple instances of type Assignment.
 */

@Entity
@Data
@Table(name = "student")
public class Student {
	
	@Column(name = "id_student")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long idStudent;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String surname;
	
	@JoinColumn(name = "id_address", referencedColumnName = "id_address")
	@ManyToOne(cascade = CascadeType.ALL)
	@Valid
	private Address address;
	
	@JoinColumn(name = "id_contact", referencedColumnName = "id_contact")
	@ManyToOne(cascade = CascadeType.ALL)
	@Valid
	private Contact contact;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<Assignment> assignments;

}
