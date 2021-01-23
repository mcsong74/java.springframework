-- FUNCTION example
CREATE OR REPLACE FUNCTION get_department_count_by_name(dep_name varchar)
    returns int
    language plpgsql
as
$$
declare
    department_count integer;
begin
    SELECT COUNT(*)
    into department_count
    FROM employees
    where department = dep_name;
    return department_count;
end;
$$

select get_department_count_by_name('Toys');


-- Function returns a table
CREATE OR REPLACE FUNCTION get_department(p_pattern varchar)
    returns table
            (
                employee_name  varchar,
                employee_email varchar
            )
    language plpgsql
as
$$

begin
    return query
        select first_name, email
        from employees
        where department ilike p_pattern;
    --- ilike ignore case
--         where department  ilike p_pattern AND email is not null ; --- ilike ignore case
end;
$$

select *
from get_department('%Oth%');

DROP FUNCTION get_department(p_pattern varchar);






