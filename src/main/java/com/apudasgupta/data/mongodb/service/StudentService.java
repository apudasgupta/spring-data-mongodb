package com.apudasgupta.data.mongodb.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.apudasgupta.data.mongodb.model.Student;

@Service
public class StudentService {

	@Autowired
	MongoOperations mongoOperations;
	
	private static final Log log = LogFactory.getLog(StudentService.class);
	
	public void insert(Student student) {
		mongoOperations.insert(student);
	    log.info("Insert: " + student);
	    System.out.println("==> inserted student: "+student.toString());
	}
}
