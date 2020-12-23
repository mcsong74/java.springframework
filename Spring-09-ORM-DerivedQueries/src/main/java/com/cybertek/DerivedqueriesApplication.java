package com.cybertek;

import com.cybertek.repository.DepartmentRepository;
import com.cybertek.repository.EmployeeRepository;
import com.cybertek.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DerivedqueriesApplication {
	@Autowired
	RegionRepository regionRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	public static void main(String[] args) {
		SpringApplication.run(DerivedqueriesApplication.class, args);
	}

	@PostConstruct
	public void testRegions(){

		System.out.println("------------------Region Starts -----------------------");
		System.out.println("");
		System.out.println("FindByCountry: " + regionRepository.findByCountry("Canada"));
		System.out.println("FindRigionsByCountry: "+regionRepository.findRegionsByCountry("Canada"));
		System.out.println("FindAllByCountry: "+regionRepository.findAllByCountry("Canada"));
		System.out.println("FindDistinctByCountry: "+regionRepository.findDistinctByCountry("Canada"));
		System.out.println("FindAllByCountryContains: "+regionRepository.findAllByCountryContains("United"));
		System.out.println("FindAllByCountryContaining: "+regionRepository.findByCountryContaining("United"));
		System.out.println("FindAllByCountryContainingOrderByRegions: "+regionRepository.findAllByCountryContainsOrderByRegion("United"));
		System.out.println("FindAllByCountryContainingOrderByCountry: "+regionRepository.findAllByCountryContainsOrderByCountry("Asia"));
		System.out.println("FindTopBy2ByCountry: "+regionRepository.findTop2ByCountry("Canada"));
		System.out.println("------------------Region Ends -----------------------");
		System.out.println("");

		System.out.println("------------------Department Starts -----------------------");
		System.out.println("");
		System.out.println("findAllByDepartment : "+departmentRepository.findAllByDepartment("Furniture"));
		System.out.println("findAllByDivision : "+departmentRepository.findAllByDivision("Health"));
		System.out.println("findByDivisionIs : "+departmentRepository.findByDivisionIs("Health"));
		System.out.println("findByDivisionEquals : "+departmentRepository.findByDivisionEquals("Health"));
		System.out.println("findByDivisionEndsWith : "+departmentRepository.findByDivisionEndsWith("ics"));
		System.out.println("findByDivisionEndingWith : "+departmentRepository.findByDivisionEndingWith("ics"));
		System.out.println("findDistinctByDivisionContaining : "+departmentRepository.findDistinctTop3ByDivisionContaining("Hea"));
		System.out.println("------------------Department Ends -----------------------");
		System.out.println("");

		System.out.println("------------------Employee Starts -----------------------");
		System.out.println("");
		System.out.println("------------------Employee Ends -----------------------");
		System.out.println("");
	}
}
