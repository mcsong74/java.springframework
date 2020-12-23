package com.cybertek.repository;


import com.cybertek.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
    //Display All departments in the funrniture department
    List<Department> findAllByDepartment(String department);
    //Display all departments in the health devision
    List<Department> findAllByDivision(String division);
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    //Display all departments with division name ends with 'ics'
    List<Department> findByDivisionEndsWith(String pattern);
    List<Department> findByDivisionEndingWith(String pattern);

    //Display top 3 departments with division name includes 'Hea', without duplicates
    List<Department> findDistinctTop3ByDivisionContaining(String pattern);

}
