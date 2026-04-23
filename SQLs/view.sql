select salary from users;

create view rich_users as
select * from users where salary > 65000;

select * from rich_users;

update users set salary=30000 where id = 4;

drop view rich_users;