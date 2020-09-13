package com.apudasgupta.data.mongodb.model;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@Data
@Document
public class Student {
//	@Id
	@MongoId private String id;
    private String name;
    
    @Indexed(unique = true, direction = IndexDirection.ASCENDING)    
    private int rollNumber;    
    private int age;
    private boolean active;
}
