package com.orm2;

import com.orm2.repository.DepartmentRepository;
import com.orm2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class OrmmappingApplication {


	public static void main(String[] args) {
		SpringApplication.run(OrmmappingApplication.class, args);
	}

}
