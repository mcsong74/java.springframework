package com.cybertek;

import com.cybertek.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DerivedqueriesApplication {
	@Autowired
	RegionRepository regionRepository;
	public static void main(String[] args) {
		SpringApplication.run(DerivedqueriesApplication.class, args);
	}

	@PostConstruct
	public void testRegions(){

		System.out.println("------------------Region Starts -----------------------");

		System.out.println("FindByCountry: " + regionRepository.findByCountry("Canada"));
		System.out.println("");
		System.out.println("FindRigionsByCountry: "+regionRepository.findRegionsByCountry("Canada"));
		System.out.println("");
		System.out.println("FindAllByCountry: "+regionRepository.findAllByCountry("Canada"));
		System.out.println("");
		System.out.println("FindDistinctByCountry: "+regionRepository.findDistinctByCountry("Canada"));
		System.out.println("");
		System.out.println("FindAllByCountryContains: "+regionRepository.findAllByCountryContains("United"));
		System.out.println("");
		System.out.println("FindAllByCountryContaining: "+regionRepository.findByCountryContaining("United"));
		System.out.println("");
		System.out.println("FindAllByCountryContainingOrderByRegions: "+regionRepository.findAllByCountryContainsOrderByRegion("United"));
		System.out.println("FindAllByCountryContainingOrderByCountry: "+regionRepository.findAllByCountryContainsOrderByCountry("United"));

		System.out.println("------------------Region Ends -----------------------");


	}
}
