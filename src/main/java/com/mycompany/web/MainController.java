package com.mycompany.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;

import com.mycompany.domain.Assignment;
import com.mycompany.domain.Course;
import com.mycompany.domain.Student;
import com.mycompany.service.iService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

/** 
 * Controller class handling web requests related to CRUD operations on Student (including Address and Contact), Course and Assignment entities.
 * The methods for each entity are built in the same way; because of this, javadoc is only generated for the first entity methods.
 */

@Controller
@Slf4j
public class MainController {
	
	@Autowired
	private iService<Student> studentService;
	
	@Autowired
	private iService<Assignment> assignmentService;
	
	@Autowired
	private iService<Course> courseService;
	
	/**
	 * Logs the currently logged-in user and returns the index page.
	 * @param model The model to add attributes to.
	 * @param user The currently logged-in user.
	 * @return The index page. 
	 */
	@GetMapping("/")
	public String index(Model model, @AuthenticationPrincipal User user) {
		
		log.info("login: " + user);
		return "index";
		
	}
	
	// Students controller methods:
	
	/** 
	 * Redirects to the listStudents page to display the list of students from the database.
	 * @return The listStudents page.
	 */
	@GetMapping("/listStudentsRedirect")
	public String listStudentsRedirect(Model model) {
		
		var students = studentService.listEntity();
		model.addAttribute("students", students);
		return "listStudents";
		
	}
	
	/** 
	 * Directs to the updateStudent page to insert or update a student element.
	 * @param student An empty student object to be populated.
	 * @return The updateStudent page.
	 */
	@GetMapping("/insertStudent")
	public String insertStudent(Student student) {
		return "updateStudent";
	}
	
	/** 
	 * Inserts a student to the database.
	 * If there are any validation errors, the method redirects to the updateStudent page again with error messages.
	 * @return root URL ("/") if the transaction was successful, or returns to the updateStudent page if errors occur.
	 */
	@PostMapping("/saveStudent")
	public String saveStudent(@Valid Student student, Errors errors) {
		
		if(errors.hasErrors()) {
			return "updateStudent";
		}
		
		studentService.saveEntity(student);
		return "redirect:/";
		
	}
	
	/** 
	 * This method uses the same page form (updateStudent) used for inserting a new student.
	 * If there is an existing student in the database with the specified ID, Spring injects that student to the student object declared as paramater.
	 * @return updateStudent page with the student object as attribute.
	 */
	@GetMapping("/editStudent/{idStudent}")
	public String editStudent(Student student, Model model) {
		
		student = studentService.findEntity(student);
		model.addAttribute("student", student);
		return "updateStudent";
		
	}
	
	/** 
	 * Deletes a student from the database.
	 * Student objects are binded to Assignment objects through a one-to-many relationship. The method is constructed in a way that
	 * if there are assignments registered to the student, the program cannot delete the student and redirects the user to a warning page.
	 * @return root URL ("/") if transaction was successful, or returns noAssignmentsError page in case of existing assignments.
	 */
	@GetMapping("/deleteStudent")
	public String deleteStudent(Student student) {
		
		try {
			studentService.deleteEntity(student);
			return "redirect:/";
			
		} catch(DataIntegrityViolationException ex) {
			return "/errors/noAssignmentsError";
		}
		
	}
	
	// Courses controller methods:
	
	@GetMapping("/listCoursesRedirect")
	public String listCoursesRedirect(Model model) {
		
		var courses = courseService.listEntity();
		model.addAttribute("courses", courses);
		return "listCourses";
		
	}
	
	@GetMapping("/insertCourse")
	public String insertCourse(Course course) {
		return "updateCourse";
	}
	
	@PostMapping("/saveCourse")
	public String saveCourse(@Valid Course course, Errors errors) {
		
		if(errors.hasErrors()) {
			return "updateCourse";
		}
		
		courseService.saveEntity(course);
		return "redirect:/";
		
	}
	
	@GetMapping("/editCourse/{idCourse}")
	public String editCourse(Course course, Model model) {
		
		course = courseService.findEntity(course);
		model.addAttribute("course", course);
		return "updateCourse";
		
	}
	
	@GetMapping("/deleteCourse")
	public String deleteCourse(Course course) {
		
		try {
			courseService.deleteEntity(course);
			return "redirect:/";
			
		} catch(DataIntegrityViolationException ex) {
			return "/errors/noAssignmentsError";
		}
		
	}
	
	// Assignments controller methods:
	
	@GetMapping("/listAssignmentsRedirect")
	public String listAssignmentsRedirect(Model model) {
		
		var assignments = assignmentService.listEntity();
		model.addAttribute("assignments", assignments);
		return "listAssignments";
		
	}
	
	@GetMapping("/insertAssignment")
	public String insertAssignment(Assignment assignment, Model model) {
		
		addListAttributes(model);
		return "updateAssignment";
		
	}
	
	@PostMapping("/saveAssignment")
	public String saveAssignment(@Valid Assignment assignment, Errors errors, Model model) {
		
		if(errors.hasErrors()) {
			addListAttributes(model);
			return "updateAssignment";
		}
		
		assignmentService.saveEntity(assignment);
		return "redirect:/";
		
	}
	
	@GetMapping("/editAssignment/{idAssignment}")
	public String editAssignment(Assignment assignment, Model model) {
		
		assignment = assignmentService.findEntity(assignment);
		addListAttributes(model);
		model.addAttribute("assignment", assignment);
		return "/updateAssignment";
		
	}
	
	@GetMapping("/deleteAssignment")
	public String deleteAssignment(Assignment assignment) {
		
		assignmentService.deleteEntity(assignment);
		return "redirect:/";
		
	}
	
	// Util methods:
	
	/** 
	 * Reusable method that adds students and courses lists as attribute to the model.
	 */
	public void addListAttributes(Model mdl) {
		
		var students = studentService.listEntity();
		var courses = courseService.listEntity();
		
		mdl.addAttribute("students", students);
		mdl.addAttribute("courses", courses);
		
	}
	
}
