package com.agnila.student.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.agnila.student.dal.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
