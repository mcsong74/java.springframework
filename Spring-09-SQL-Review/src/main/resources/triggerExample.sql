DROP TABLE IF EXISTS mentors;
CREATE TABLE mentors
(
    -- below spring will generate auto id
    id         INT generated always as identity,
    first_name varchar(40) not null,
    last_name  varchar(40) not null,
    primary key (id)
);

DROP TABLE IF EXISTS mentor_audit;
CREATE TABLE mentor_audit
(
    -- below spring will generate auto id
    id         INT generated always as identity,
    mentor_id INT not null,
--     first_name varchar(40) not null,
    last_name  varchar(40) not null,
    changed_on timestamp(6) not null
);

insert into mentors(first_name, last_name) values ('Mike', 'Smith');
insert into mentors(first_name, last_name) values ('Tom', 'Hanks');
-- triggers will add any changes of last name in audit table
CREATE OR REPLACE FUNCTION log_last_name_changes()
    returns trigger
    language plpgsql
as
$$
begin
    if New.last_name<>OLD.last_name then -- structure auto catch new and old value
        insert into mentor_audit(mentor_id, last_name, changed_on)
        values (OLD.id, OLD.last_name, now());
    end if;
    RETURN new;
end
$$;

CREATE TRIGGER  last_name_change
    BEFORE update
    On mentors
    FOR EACH ROW
EXECUTE PROCEDURE log_last_name_changes();


update mentors set last_name='ABC' where id=2;


CREATE TRIGGER  last_name_change2
    AFTER update
    On mentors
    FOR EACH ROW
EXECUTE PROCEDURE log_last_name_changes();

update mentors set last_name='XYZ' where id=2;

select * from pg_trigger; -- displays all triggers

drop trigger if exists  last_name_change2 on mentors;

