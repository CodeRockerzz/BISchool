/**
 * 
 */
package com.oxford.studenttest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oxford.studenttest.pojo.Student;
import com.oxford.studenttest.pojo.User;
import com.oxford.studenttest.repository.TestRepository;
import com.oxford.studenttest.repository.TestRepositoryUser;
import com.oxford.studenttest.service.TestService;

/**
 * @author barathkumar.karthike
 *
 */
@Service
public class TestServiceImpl implements TestService {

	@Autowired
	TestRepository testRepository;
	
	@Autowired
	TestRepositoryUser testRepositoryUser;
	
	
	@Override
	public void addStudent(Student student) {
		
		testRepository.save(student);
		
	}
	
	@Override
	public void deleteStudent(Student student) {
		testRepository.delete(student);
	}
	
	
	@Override
	public String login(Student student) {
		
		Student existingStudent=testRepository.findByEmail(student.getEmail());
		//User exisitingUser=testRepositoryUser.findByName(user.getName());
		if(existingStudent!=null)
		{
			if(existingStudent.getPassword().equals(student.getPassword()))
			{
				return "Valid User";
			}
		}
		return "Invalid User";
		
	}
	
		
	public void updateStudent(Student student) {
		testRepository.save(student);
	}
	
	public List<Student> getAllStudent()
	{
		return testRepository.findAll();
	}
	

}
