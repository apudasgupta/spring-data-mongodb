package com.apudasgupta.data.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.apudasgupta.data.mongodb.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
	List<Student> findByName(String name);

	List<Student> findByNameNull();// {"name" : null}

	List<Student> findByNameLike(String name);

	List<Student> findByActiveIsTrue();// {"active" : true}

	List<Student> findByAge(int age);// {"age" : {"$gt" : age}}

	List<Student> findByAgeGreaterThan(int age);// {"age" : {"$gt" : age}}

	List<Student> findByAgeLessThan(int age);// {"age" : {"$lt" : age}}

	List<Student> findByAgeBetween(int from, int to);// {"age" : {"$gt" : from, "$lt" : to}}

	@Query(value = "{ 'name' : ?0 }", fields = "{ 'name' : 1, 'age' : 1}")
	List<Student> findByTheStudentNameAndAge(String name);
	
	
	void deleteAll() ;

}
