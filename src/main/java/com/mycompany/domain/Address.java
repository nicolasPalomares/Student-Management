package com.mycompany.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/** 
 * This class represents an address entity in the system. This entity should be an existing address belonging to a student.
 * @param idAddress - The auto increment primary key of Address instances managed inside the database.
 * @param street - The street name of the student's address (for test cases, the street names used for this parameter are non-existent).
 * @param streetNo - The number of the street; it can be any number registered to an address (for test cases, the street names used for this parameter are non-existent).
 * @param country - The country in wich the address is located; it's not restricted to a specific zone, it can be any country in the world.
 * 
 * The creation of address objects takes place when the user is creating an instance of type Student, this means that the address is not managed independently.
 */

@Entity
@Data
@Table(name = "address")
public class Address {
	
	@Column(name = "id_address")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long idAddress;
	
	@NotEmpty
	private String street;
	
	@Column(name = "street_no")
	@NotEmpty
	private String streetNo;
	
	@NotEmpty
	private String country;

}
