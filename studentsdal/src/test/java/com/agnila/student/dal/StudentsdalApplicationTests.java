package com.agnila.student.dal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.agnila.student.dal.entities.Student;
import com.agnila.student.dal.repos.StudentRepository;

@SpringBootTest
class StudentsdalApplicationTests {

//	to perform the create operation, we need student repository.
	@Autowired // wit this mark, springboot will magically inject at runtime for us
	private StudentRepository repo; // here in test method, testCreateStudent() we are injecting directly. but when create web layer, i will inject this repo to service classes into controller classes.
	
	@Test // created a test method testCreateStudent; created a student entity and fill the details in the repo. use the repo to inject it in the testmethod in autowired  studentrepo
	void testCreateStudent() {
		Student student = new Student(); //repo.save (new Student()) now select new Student() and ctrl+1, extract to local variable
		student.setName("Moumi");  //don't need to set it as it was auto increment field
		student.setCourse("Centennial College: soft eng");
		student.setFee(3700d); // set all the fields
		repo.save(student); //to perform the insert operation, passing the student object to repo.save
	} // after running the junit test, you can see in the console hibernate has inserted the data in mysql database.
	
	//now read the record from the database
	
	@Test
	void testFindStudentById() {
		Student student = repo.findById(1l).get(); // this method is passed in the id. 1l will return to optional student(place the cursor on findById); .get will give us the student object back after finishing the query
		System.out.println(student); // only this method will run after inserting the record. the student record is rendered in the console & Junit test is also green
	}
	
	// update the student
	@Test
	void testUpdateStudent() {
		Student student = repo.findById(1l).get(); // not creating student entity but fetch it and update it. so copy the read operation 
		student.setFee(12000d);
		repo.save(student); //Spring data JPA  will figure that student already have a key set,as fetching the record from database which is 1;
		// loking at the primary key [id], that is 1; JPA will update that. instead of inserting a new record
	}
	
	//  delete the student
	@Test
	void testDeleteStudent(){
		Student student = repo.findById(1l).get();
		repo.delete(student);// deleteall: delete everything; delete: pass object, deletebyID: pass an id
	}
}
