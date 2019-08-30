package com.test02;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class School {
	
	@Autowired
	@Qualifier("lee")	// Autowired는 type이 하나만 있어야 되는데 이렇게 써주면 잘 찾아감 !!!
	@Resource(name="hong")	// 같은 역할, 차이점은 Qualifier는 type 먼저 찾고 name, Resource는 반대!!
	private Student person;
	
	private int grade;

	public School() {

	}

	public School(Student person, int grade) {

		this.person = person;
		this.grade = grade;
	}

	public Student getPerson() {
		return person;
	}

	public void setPerson(Student person) {
		this.person = person;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "School [person=" + person + ", grade=" + grade + "]";
	}
	
	

}
