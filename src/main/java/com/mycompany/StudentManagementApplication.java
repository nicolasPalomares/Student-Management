package com.mycompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** 
 * PRECONDITION: If the user wants to execute the program, it is necessary to configure the database first. For this, I exported an SQL file
 * with all the tables and data originally created from my PostgreSQL software. That file is located inside "psql_database_backup" folder inside the project directory.
 * Load it inside any SQL database software, and then complete the "application.properties" file with your database credentials.
 * 
 * This Java Spring web application is designed to efficiently manage elements within an educational institution. This elements are:
 * - Students; each student has an Address and a Contact.
 * - Courses
 * - Assignments
 * 
 * The program allows administrators to:
 * - Visualize the list of students, courses and assignments.
 * - Add, update and delete student records.
 * - Create and manage course information, including course name and price.
 * - Assign and manage assignments for each course to any registered student, specifying a student, a course, and a shift.
 * 
 * Users can only use the application to:
 * - Visualize the list of students, courses and assignments.
 * 
 * Key Features:
 * - User/Admin authentication and authorization ensure secure acces to the system.
 * - Spring Security provides robust authentication and authorization mechanisms.
 * - Hibernate ORM simplifies database interactions, ensuring data integrity.
 * - Thymeleaf templates facilitate dynamic web page rendering.
 * - RESTful APIs are utilized for seamless integration with front-end applications.
 * 
 * Architecture:
 * This application follows the Model-View-Controller (MVC) architecture pattern, with Spring Boot providing the framework for rapid development and deployment.
 * - Controller handles incoming HTTP requests, routes them to the appropiate services, and returns responses to clients.
 * - Services and DAO classes encapsulate business logic and interact with repositories for database operations.
 * - Entities represent database elements and are mapped to Java objects.
 * - HTML pages represent the View layer for every logic operation.
 * 
 * External Dependencies:
 * - PostgreSQL database for persistence storage of student (including address and contact), course, assignment, user and role (USER, ADMIN) data.
 * - Spring Boot Starter Web for building web applications (using Spring Tools 4 plugin).
 * - Spring Data JPA for simplifying database access.
 * - Spring Security for implementing authentication and authorization.
 * - Spring Boot Starter Validation for validating data in the application.
 * 
 * (For detailed documentation of each class, method and component, please refer to the generated Javadoc)
 */

@SpringBootApplication
public class StudentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

}
