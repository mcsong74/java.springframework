package com.cybertek.repository;

import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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

    //Not equal
    @Query("select e from Employee e where e.salary <> :salary")
    List<Employee> getEmployeeBySalaryNotEqual(@Param("salary") int salary);

    //Like/contains/starts with/ends with
    @Query("select e from Employee e where e.firstName like ?1")
    List<Employee> getEmployeeByFirstNameLike(String pattern);
    //Less than
    @Query("select e from Employee e where e.salary < ?1")
    List<Employee> getEmployeeBySalaryLessThan(int salary);
    //Greater than
    @Query("select e from Employee e where e.salary > ?1")
    List<Employee> getEmployeeBySalaryGreaterThan(int salary);
    //between
    @Query("select e from Employee e where e.salary between ?1 and ?2")
    List<Employee> getEmployeeBySalaryBetween(int salary1, int salary2);
    //before
    @Query("select e from Employee e where e.hireDate < ?1")
    List<Employee> getEmployeeByHireDateBefore(LocalDate date);
    //Null
    @Query("select e from Employee e where e.email is null ")
    List<Employee> getEmployeeByEmailIsNull();
    //not null
    @Query("select e from Employee e where e.email is not null ")
    List<Employee> getEmployeeByEmailIsNotNull();
    //Sort salary in ascending order
    @Query("select e from Employee e order by e.salary asc")
    List<Employee> getEmployeeBySalaryOrderByAsc();
    //Sort salary in descending order
    @Query("select e from Employee e order by e.salary desc ")
    List<Employee> getEmployeeBySalaryOrderBydesc();

    //native query
    @Query(value = "Select * from employees where salary=?1", nativeQuery = true)
    List<Employee> readEmployeeBySalary(int salary);





}
