package com.mycompany.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/** 
 * Assignment instances work as intermediaries for student-course relationship. Whitout this class, Student and Course classes would handle many-to-many relationships and
 * it wouldn't be very practical. 
 * @param idAssignment - The auto increment primary key of Assignment instances managed inside the database.
 * @param shift - The shift in wich the student was registered to the course; I handled three String options in the view: "morning", "afternoon" and "night".
 * @param student - Represents a Student instance retrieved form the database and associated with the assignment, mapped to the "id_student" column in the Student database table.
 * @param course - Represents a Course instance retrieved form the database and associated with the assignment, mapped to the "id_course" column in the Course database table.
 */

@Entity
@Data
@Table(name = "assignment")
public class Assignment {
	
	@Column(name = "id_assignment")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long idAssignment;
	
	@NotEmpty
	private String shift;
	
	@NotNull
	@JoinColumn(name = "id_student", referencedColumnName = "id_student")
	@ManyToOne(cascade = CascadeType.ALL)
	@Valid
	private Student student;
	
	@NotNull
	@JoinColumn(name = "id_course", referencedColumnName = "id_course")
	@ManyToOne(cascade = CascadeType.ALL)
	@Valid
	private Course course;

}
