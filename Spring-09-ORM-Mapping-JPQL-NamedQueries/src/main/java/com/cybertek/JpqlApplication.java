package com.cybertek;

import com.cybertek.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class JpqlApplication {

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {

		SpringApplication.run(JpqlApplication.class, args);
	}

	@PostConstruct
	public void testEmployee(){
		System.out.println("employeeRepository.getEmployeeDetail() = "
				+ employeeRepository.getEmployeeDetail());
		System.out.println("employeeRepository.getEmployeeSalary() = "
				+ employeeRepository.getEmployeeSalary());

		System.out.println("employeeRepository.getEmployeeByEmail(\"myakovlivf@ucsd.edu\") = "
				+ employeeRepository.getEmployeeByEmail("myakovlivf@ucsd.edu").get());

		employeeRepository.updateEmployeeJPQL(1);
		employeeRepository.updateEmployeeNativeQuery(1);
	}

}
