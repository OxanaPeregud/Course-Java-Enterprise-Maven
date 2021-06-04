drop table if exists employee;
create table if not exists employee
(
    employee_id  int auto_increment
        primary key,
    salary        float       not null,
    department    int         not null
);

insert into employee(salary, department)
values (4000, 1);
insert into employee(salary, department)
values (2500, 2);
insert into employee(salary, department)
values (5100, 2);
insert into employee(salary, department)
values (2700, 1);
insert into employee(salary, department)
values (3700, 1);

