CREATE SEQUENCE employee_seq INCREMENT 1 START 1;


create TABLE employee
(
    id            int         NOT NULL,
    employee_name varchar(80) NOT NULL
   --  company_id int not null
);
