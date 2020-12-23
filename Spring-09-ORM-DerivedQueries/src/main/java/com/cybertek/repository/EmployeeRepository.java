package com.cybertek.repository;


import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //Display all employees with email address '...'
    List<Employee> findByEmail(String email);

    //Display all employee with firstname '' and last name '', and also show all employees with a email address ''
//    List<Employee> findAllByFirstNameIsAnAndLastNameIsOrEmailIs(String firstName, String lastName, String email);
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    //Display all employees that first name is not ''
    List<Employee> findByFirstNameIsNot(String firstName);

    //Display all employess where last name starts with ''
    List<Employee> findByLastNameStartsWith(String pattern);

    //Display all employees with salaries higher than ''
    List<Employee> findBySalaryGreaterThan(Integer salary);
    //Display all employees with salaries less than ''
    List<Employee> findBySalaryLessThan(Integer salary);

    //Display all employees that has been hired between '' and ''
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //Display all employess where salaries greater and equal to '' in order
    List<Employee> findAllBySalaryGreaterThanEqualOrderBySalary(Integer Salary);

    //Display top unique 3 employees that is making less than ''
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employees that do not have email address
    List<Employee> findByEmailIsNull();



}
