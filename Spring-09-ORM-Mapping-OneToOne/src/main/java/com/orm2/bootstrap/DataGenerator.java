package com.orm2.bootstrap;

import com.orm2.entity.Departments;
import com.orm2.entity.Employees;
import com.orm2.enums.Gender;
import com.orm2.repository.DepartmentRepository;
import com.orm2.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {

    DepartmentRepository departmentRepository;
    EmployeeRepository employeeRepository;

    public DataGenerator(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Employees e1 = new Employees("Berrie", "Manueau", "bmanueau0@dion.ne.jp", LocalDate.of(2006,04,20), Gender.F,
                154864);
        Employees e2 = new Employees("Aeriell", "McNee", "amcnee1@google.es", LocalDate.of(2009,01,26), Gender.F,56752);
        Employees e3 = new Employees("Sydney", "Symonds", "ssymonds2@hhs.gov", LocalDate.of(2010,05,17), Gender.F,95313);
        Employees e4 = new Employees("Avrom", "Rowantree", null, LocalDate.of(2014,03,02), Gender.M,119764);
        Employees e5 = new Employees("Feliks", "Morffew", "fmorffew4@a8.net", LocalDate.of(2003,01,14), Gender.M,55307);

        List<Employees> employeeList=new ArrayList<>();
        employeeList.addAll(Arrays.asList(e1,e2,e3,e4,e5));

        Departments d1 = new Departments("Sports","Outdoors");
        Departments d2 = new Departments("Tools","Hardware");
        Departments d3 = new Departments("Clothing","Home");
        Departments d4 = new Departments("Phones & Tablets","Electronics");
        Departments d5 = new Departments("Computers","Electronics");
        List<Departments> departmentList=new ArrayList<>();
        departmentList.addAll(Arrays.asList(d1,d2,d3,d4,d5));

        employeeRepository.saveAll(employeeList);
        departmentRepository.saveAll(departmentList);
    }


}
