-- SELECT, FROM, WHERE, ...
SELECT *
FROM departments;

SELECT *
FROM employees;

SELECT *
FROM regions;

SELECT employee_id, first_name, department
FROM employees;

SELECT *
FROM employees
WHERE department = 'Sports';

SELECT *
FROM employees
WHERE department LIKE '%nit%';

SELECT *
FROM employees
WHERE department LIKE 'F%nit%';

SELECT *
FROM employees
WHERE salary > 100000;

SELECT *
FROM employees
WHERE salary <= 100000;

SELECT *
FROM employees
WHERE department = 'Clothing'
  AND salary > 90000;

SELECT *
FROM employees
WHERE department = 'Clothing'
  AND salary > 90000
  AND region_id = 2;

SELECT *
FROM employees
WHERE department = 'Clothing'
   OR salary > 90000;

SELECT *
FROM employees
WHERE salary < 40000
  AND (department = 'Clothing' OR department = 'Pharmacy');

SELECT *
FROM employees
-- WHERE department !='Sports';
-- WHERE department <> 'Sports';
WHERE NOT department <> 'Sports';

SELECT *
FROM employees
-- where email is null ;
where email is not null;

select *
from employees
-- where department='Sports' or department='First Aid' or department='Toys' or department='Garden';
where department in ('Sports', 'First Aid', 'Toys', 'Garden');

SELECT *
FROM employees
WHERE salary BETWEEN 80000 AND 100000;

--Write a query that returns the first name and email of females that work in the tools department
-- having a salary greater than 110000
SELECT first_name, email
FROM employees
WHERE gender = 'F'
  and salary > 110000
  and department in ('Tools');
--Write a query that returns the first name and hire date of those employees who earn more than 165000
-- as well as those employees that work in the sport department and also happen to be man
SELECT first_name, hire_date, gender, salary, department
FROM employees
WHERE salary > 165000
   or (department = 'Sports' and gender = 'M');

SELECT *
FROM employees
ORDER BY employee_id DESC;

SELECT DISTINCT department
FROM employees;

SELECT DISTINCT department
FROM employees
    FETCH FIRST 3 ROWS ONLY; -- TOP 3 in SQL server

SELECT salary as yearly_salary
FROM employees;

--Write a query that displays the name and ages of the top 4 oldest students
SELECT *
FROM students
Order By age desc
    FETCH first 4 ROWS only;

-- Write a query that returns students based on the following criteria;
-- the student must not be older than age 20 if their student_no is either between 3 and 5
-- or their student_no is 7. your query should also return students older than age 20 but in that case
-- they must have a student_no that is at least 4
SELECT *
FROM students
WHERE age <= 20 and (student_no between 3 and 5 or student_no = 7)
   OR (age > 20 and student_no >= 4);

-- FUNCTIONS --
SELECT upper(first_name), lower(department)
FROM employees;

SELECT length(first_name)
FROM employees;

SELECT TRIM('   Hello There   '); -- remove space start and end
SELECT LENGTH('   Hello There   ');
SELECT LENGTH(TRIM('   Hello There   '));

SELECT first_name || ' ' || last_name as Full_Name
from employees;

SELECT (salary > 140000)
FROM employees;

SELECT employee_id, first_name, last_name, salary, (salary > 140000) as high_paid
from employees
order by salary desc;

SELECT department, (department like '%oth%')
from employees;

SELECT 'This is a test data' test_data;

select SUBSTRING('this is a test data' from 1 for 4) as Test_Data;
select substr('This is a test data', 1, 4) as Test_Data;
select substring('This is a test data' from 9) as Test_Data;

SELECT department, replace(department, 'Clothing', 'Clothes')
from departments;

-- GROUP, AGGRIGATE FUNCTIONS --
SELECT MAX(salary), MIN(salary), AVG(salary)
FROM employees;

SELECT ROUND(AVG(salary))
FROM employees;

SELECT COUNT(employee_id)
FROM employees;

SELECT COUNT(email)
FROM employees;

SELECT SUM(salary)
FROM employees
where department = 'Clothing';

-- Write a query that returns all of the records and columns from the professor table
-- But shortens the department names to only the first three characters in upper case.
SELECT last_name, upper(substring(department, 1, 3)) as department, hire_date
FROM professors;

-- Write a query that returns the highest and lowest salary from the professors table
-- excluding the professor named 'Wilson'
SELECT MAX(salary) as max_salary, MIN(salary) as min_salary
FROM professors
where last_name != 'Wilson';

SELECT count(*), department
from employees
group by department;

SELECT SUM(salary) as total_salary, department
from employees
group by department;

SELECT MIN(salary)        as min_salary,
       MAX(salary)        as max_salary,
       ROUND(AVG(salary)) as average_salary,
       Count(*)           as total_number_employees,
       department
from employees
group by department;

select Sum(salary) as total_salary, department
from employees
where region_id in (4, 5, 6, 7)
group by department;

select department, count(*) as employee_Number_in_Department
from employees
group by department
order by department;

select department, count(*) as employee_Number_in_Department
from employees
group by department
having count(*) < 36
order by department;

-- show all unique domain and number of employees
select count(*), (substring(email, position('@' in email) + 1)) email_domain
from employees
where email is not null
GROUP BY email_domain;

-- Sub Query --
SELECT e.department
FROM employees e,
     departments d;

SELECT department
from employees;

SELECT *
FROM employees
where department not in (SELECT department from departments);

SELECT *
FROM (SELECT * from employees where salary > 15000) a;
-- FROM sub query need to return table


-- returns all employees that work in electronic division
SELECT *
from employees
where department in (select department from departments where division = 'Electronics');

-- returns all employees work in ASIA or CANADA make more than 130000
SELECT *
FROM regions;

SELECT *
FROM employees
where region_id in (select region_id from regions where country in ('Asia', 'Canada'));

-- first name where work in asia or canada and how much less making from the highest employee in the company
SELECT first_name
     , (select MAX(salary) from employees)
     , salary
     , (select MAX(salary) from employees) - salary as Differences
FROM employees
where region_id in (select region_id from regions where country in ('Asia', 'Canada'));

-- write a query that returns all of those employees that work in the kids division and
-- the dates at which those employees were hired is greater than all of the hire_dates of
-- employees who work in the maintenance department
SELECT *
FROM employees
where department = ANY (SELECT department from departments where division = 'Kids')
  AND hire_date > ALL (SELECT hire_date from employees where department = 'Maintenance');

-- write a query that returns the names of those students
-- that are taking courses Physics and US History
SELECT *
from students;

select *
from student_enrollment;

SELECT *
FROM student_enrollment
WHERE course_no = ANY (Select course_no from courses where course_title in ('Physics', 'US History'));

select *
from courses;
SELECT student_name
FROM students
Where student_no in (
    SELECT student_no
    FROM student_enrollment
    WHERE course_no = ANY (
        Select course_no
        from courses
        where course_title in ('Physics', 'US History'))
);

---- CASE statement
SELECT first_name,
       salary,
       CASE
           when salary < 100000 then 'UNDER PAID'
           when salary > 100000 then 'PAID WELL'
           ELSE 'UNPAID'
           END as Category
FROM employees;

SELECT category, COUNT(*)
From (SELECT first_name, salary,
             CASE
                 when salary < 100000 then 'UNDER PAID'
                 when salary > 100000 AND salary < 160000 then 'PAID WELL'
                 ELSE 'EXECUTIVE'
                 END as category
      FROM employees
     ) a
GROUP BY category;

-- Joins --

SELECT first_name, country
From employees e, regions r
WHERE r.region_id=e.region_id;

SELECT first_name, email, division, d.department
FROM employees e, departments d, regions r
WHERE e.department=d.department AND e.region_id=r.region_id;

SELECT first_name, country
FROM employees INNER  JOIN regions
ON employees.region_id=regions.region_id;

SELECT first_name, email, division
FROM employees e INNER JOIN departments d
    on e.department = d.department
WHERE email is not null;

SELECT  first_name, email, division, country
FROM employees e
    INNER JOIN departments d on e.department = d.department
    INNER JOIN regions r on e.region_id=r.region_id
WHERE email is not null;

SELECT  distinct  department from employees;
SELECT distinct department from departments;

SELECT distinct e.department, d.department
FROM employees e LEFT JOIN departments d on e.department=d.department;

SELECT distinct e.department, d.department
FROM employees e FULL JOIN departments d on e.department=d.department;

---- UNION and UNION ALL
SELECT department FROM employees
UNION
SELECT department from departments;

SELECT department FROM employees
UNION
SELECT department from departments
UNION
SELECT country from regions;

SELECT department FROM employees
UNION ALL
SELECT department from departments;

SELECT department FROM employees
UNION ALL
SELECT department from departments
UNION ALL
SELECT country from regions;

SELECT department FROM employees
EXCEPT
SELECT department from departments;
































