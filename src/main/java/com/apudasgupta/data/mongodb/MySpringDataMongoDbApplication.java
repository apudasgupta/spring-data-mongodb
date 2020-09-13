package com.apudasgupta.data.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MySpringDataMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringDataMongoDbApplication.class, args);
	}

}
