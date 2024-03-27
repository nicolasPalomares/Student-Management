package com.mycompany.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/** 
 * This class represents a course entity in the system. This entity should represent courses offered by an institution. For test cases,
 * names and prices are simulated.
 * @param idCourse - The auto increment primary key of Course instances managed inside the database.
 * @param name - Name of the course.
 * @param price - Price of the course.
 * @param assignments - A list containing instances of Assignment, mapped to the "course" column in the assignment table. Since is annotated with one-to-many,
 * an instance of Course can be related to multiple instances of type Assignment.
 */

@Entity
@Data
@Table(name = "course")
public class Course {
	
	@Column(name = "id_course")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long idCourse;
	
	@NotEmpty
	private String name;
	
	@NotNull
	private Double price;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<Assignment> assignments;

}
