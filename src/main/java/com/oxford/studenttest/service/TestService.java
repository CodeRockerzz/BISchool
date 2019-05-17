/**
 * 
 */
package com.oxford.studenttest.service;

import java.util.List;

import com.oxford.studenttest.pojo.Student;
import com.oxford.studenttest.pojo.User;

/**
 * @author barathkumar.karthike
 *
 */
public interface TestService {

	void addStudent(Student student);
	
	String login(Student student);
	
	void updateStudent(Student student);
	
	void deleteStudent(Student student);
	
	List<Student> getAllStudent();

}
