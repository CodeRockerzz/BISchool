/**
 * 
 */
package com.oxford.studenttest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oxford.studenttest.pojo.Student;
import com.oxford.studenttest.pojo.User;

/**
 * @author barathkumar.karthike
 *
 */
@Repository
public interface TestRepository extends JpaRepository<Student, Integer> {

	Student findByEmail(String email);
}
