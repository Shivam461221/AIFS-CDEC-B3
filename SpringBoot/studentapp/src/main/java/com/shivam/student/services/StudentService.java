package com.shivam.student.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shivam.student.entities.Student;

@Service
public class StudentService {

	List<Student> students = new ArrayList<>(
			Arrays.asList(new Student(101, "Sagar", "Btech"), new Student(102, "Pallavi", "MCA")));
	
	public List<Student> getAllStudents(){
		return students;
	}
	
	public Student getStudentById(int id) {
		return students.stream().filter(s->s.getId()==id).findFirst().orElse(null);
	}
	
	public String addStudent(Student student) {
		students.add(student);
		return "Student added";
	}
	
	public String removeStudent(int id) {
		students.removeIf(s->s.getId()==id);
		return "Student removed";
	}
	
	public String updateStudent(int id, Student student) {
		for(Student s:students) {
			if(s.getId()==id) {
				s.setName(student.getName());
				s.setCourse(student.getCourse());
				return "Student Updated";
			}
		}
		
		return "Student not found";
	}
}
