package com.agnila.student.dal.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Converting this model class into JPA entity, we need :
//1) mark this class with @ entity annotation. it will import jakarta.persistence; this class will map into the database table
@Entity
@Table(name = "studenttab") // if the name of dbtable is same as this model class, we would not need this
							// extra work

public class Student {

//	four fields: id, name, sourse, fee
	// 2) fields level annotations of its four coloumn, smae name in the table so no
	// need for additional annotation
	@Id
	
	// As id is auto incremented, we need to mark it with jakarta.persistence . it will tell JPA provider like Hibernate to automate the increment this field. not provided by test class
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	// now fied name: name but in table it is, stuname. hence different annotation
	@Column(name="stuname")
	private String name;
	@Column(name="stucourses")
	private String course;
	@Column(name="stufee")
	private Double fee; // wrapper type

	// generate getter and setter, pinpoint after which u will want them,
	// ctrl+shift+f for format

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	// generate toString to display the entities

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + ", fee=" + fee + "]";
	}

}
