package com.apudasgupta.data.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apudasgupta.data.mongodb.model.Student;
import com.apudasgupta.data.mongodb.repository.StudentRepository;
import com.apudasgupta.data.mongodb.service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/student")
@Api(tags = "Student")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentService studentService;
	
	
	@PostMapping("/add")
	@ApiOperation(value = "Add new Student",notes = ":: Add new Student :: ",response = Student.class)
	public String add(@RequestBody Student student) {
//		studentRepository.save(student); // ok
		studentService.insert(student);
		return "added";
	}
	
	
	@GetMapping("/getAll")
	@ApiOperation(value = "Get All Students",notes = ":: Get All Students :: ",response = Student.class)
	public List<Student> getAll() {
		return studentRepository.findAll();
		
	}
	
	@GetMapping("/getAllActive")
	@ApiOperation(value = "Get All Active Students",notes = ":: Get All Active Students :: ",response = Student.class)
	public List<Student> getAllActive() {
		return studentRepository.findByActiveIsTrue();
		
	}
	
	@GetMapping("/getAllByName")
	@ApiOperation(value = "Get Students by Name",notes = ":: Get Students by Name :: ",response = Student.class)
	public List<Student> getAllByName(@RequestParam String name) {
		return studentRepository.findByNameLike(name);
		
	}
	
	@GetMapping("/getAllByAge")
	@ApiOperation(value = "Get Students by Age",notes = ":: Get Students equal to Age :: ",response = Student.class)
	public List<Student> getAllByAge(@RequestParam int age) {
		return studentRepository.findByAge(age);
		
	}
	@GetMapping("/getAllByAgeLessThan")
	@ApiOperation(value = "Get Students by Age",notes = ":: Get Students Less than  Age :: ",response = Student.class)
	public List<Student> getAllByAgeLessThan(@RequestParam int age) {
		return studentRepository.findByAgeLessThan(age);
		
	}
	
	@GetMapping("/findByNameGetNameAndAge")
	@ApiOperation(value = "Get Students Name and Age by name",notes = ":: Get Students Name and Age by name :: ",response = Student.class)
	public List<Student> findByTheStudentNameAndAge(@RequestParam String name) {
		return studentRepository.findByTheStudentNameAndAge(name);
		
	}
	
	@PostMapping("/deleteAll")
	@ApiOperation(value = "Delete All Students",notes = ":: Delete All Students :: ",response = String.class)
	public String deleteAll() {
		studentRepository.deleteAll(); 
		return "Deleted All Students";
	}
	
}
