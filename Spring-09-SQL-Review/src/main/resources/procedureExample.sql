-- PROCEDURE
CREATE OR REPLACE PROCEDURE  update_department(emp_id int)
language  plpgsql
as
$$
    declare
    begin
        update employees set department='Toys' where employee_id = emp_id;
        commit;
    end
$$;


call update_department(1);

select * from employees where employee_id=1;