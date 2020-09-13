package com.apudasgupta.data.mongodb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.WriteResultChecking;

import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig {

	@Bean
	public MongoClient mongoClient() {
		System.out.println("==> configuring mongoClient ---");
		return MongoClients.create("mongodb://localhost:27017");
	}

	public @Bean MongoTemplate mongoTemplate() {
		System.out.println("==> configuring mongoTemplate ---");
		MongoTemplate mongoTemplate = new MongoTemplate(mongoClient(), "myschool");
		mongoTemplate.setWriteConcern(WriteConcern.ACKNOWLEDGED);
		mongoTemplate.setWriteResultChecking(WriteResultChecking.EXCEPTION);
		return mongoTemplate;
	}
}
