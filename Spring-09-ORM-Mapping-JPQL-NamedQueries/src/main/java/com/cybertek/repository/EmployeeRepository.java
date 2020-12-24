package com.cybertek.repository;

import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e FROM Employee e where e.email='dtrail8@tamu.edu'")
    Employee getEmployeeDetail();

    @Query("select e.salary from Employee e where e.email='dtrail8@tamu.edu'")
    Integer getEmployeeSalary();

    //Single positional bind parameter
    @Query("select e from Employee e where e.email=?1")
    Optional<Employee> getEmployeeByEmail(String email); //optional protects null pointer exception when it is null
    //multiple positional bind parameter
    @Query("select e from Employee e where e.email=?1 and e.salary=?2")
    Employee getEmployeeByEmailAndSalary(String email, Integer salary);

    //single named parameter
    @Query("select e from Employee e where e.salary=:salary")
    Employee getEmployeeBySalary(@Param("salary") Integer salary);
    //multiple named parameter
    @Query("select e from Employee e where e.firstName=:firstname or e.salary=:salary")
    List<Employee> getEmployeeByFirstNameOrSalary(@Param("firstname") String firstname, @Param("salary") int salary);




}
