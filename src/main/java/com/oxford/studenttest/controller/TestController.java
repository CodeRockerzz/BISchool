/**
 * 
 */
package com.oxford.studenttest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oxford.studenttest.pojo.Student;
import com.oxford.studenttest.pojo.User;
import com.oxford.studenttest.service.TestService;

/**
 * @aut
 * hor barathkumar.karthike
 *
 */

@RestController
@CrossOrigin(origins = "*") 
public class TestController {

	@Autowired
	TestService testService;
	
	@Autowired
	Environment environment;

	
	@GetMapping("/backend")
	public String backend() {
		System.out.println("Inside MyRestController::backend...");

		String serverPort = environment.getProperty("local.server.port");

		System.out.println("Port : " + serverPort);
		
		return "Hello form Backend!!! " + " Host : localhost " + " :: Port : " + serverPort;
	}
	
	@PostMapping("/putStudentAdmission")
	public void putAdmission(@RequestBody Student student) {

		System.out.println("Add Student is"+student);
		testService.addStudent(student);
		System.out.println("Inside Put Admission");

	}
	
	
	@GetMapping("/getAllAdmission")
	public List<Student> getAllAdmission() {

		return testService.getAllStudent();
	//	System.out.println("Inside Put Admission");

	}
	

	@PostMapping("/login")
    public List<String> login(@RequestBody Student studnent) {
       
	 System.out.println("User is"+studnent);
	 
	 System.out.println(studnent.getEmail());
	 
	 System.out.println(studnent.getPassword());
	 
	 List<String> n=new ArrayList<String>();
	
	 n.add(testService.login(studnent));
 	 return  n;
	 
	 //return "Inside Login Method";
	 
	 
    }
	
	@GetMapping("/addUsingGet")
    public void addStudentUsingGet() {
       
		Student student=new Student();
		student.setId(1);
		student.setFirstName("Barath");
		student.setLastName("kumar");
		student.setEmail("barathrockz6@gmail.com");
		student.setPassword("barath@123");
		
		testService.addStudent(student);
    }
	
	 @PostMapping("/deleteStudent")
	public void deleteStudent(@RequestBody Student student) {

		testService.deleteStudent(student);
		System.out.println("Inside Put Admission");

	}
	/*
	@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
       
	 System.out.println("User is"+user);
	 
	 System.out.println(user.getName());
	 
	 System.out.println(user.getPassword());
	 
	 return new ResponseEntity<>(testService.login(user),HttpStatus.OK);
	 
	 
	 //return "Inside Login Method";
	 
	 
    }*/
	
	/*
	 * @PostMapping("/updateStudentAdmission")
	public void updateAdmission(@RequestBody Student student) {

		testService.addStudent(student);
		System.out.println("Inside Put Admission");

	}
	 */
}

