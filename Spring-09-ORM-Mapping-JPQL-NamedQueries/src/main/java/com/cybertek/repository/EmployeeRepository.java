package com.cybertek.repository;

import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e FROM Employee e where e.email='dtrail8@tamu.edu'")
    Employee getEmployeeDetail();

    @Query("select e.salary from Employee e where e.email='dtrail8@tamu.edu'")
    Integer getEmployeeSalary();

    //Single bind parameter
    @Query("select e from Employee e where e.email=?1")
    Optional<Employee> getEmployeeByEmail(String email); //optional protects null pointer exception when it is null

    @Query("select e from Employee e where e.email=?1 and e.salary=?2")
    Employee getEmployeeByEmailAndSalary(String email, Integer salary);



}
