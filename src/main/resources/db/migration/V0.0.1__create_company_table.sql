CREATE SEQUENCE company_seq INCREMENT 1 START 1;


create TABLE company
(
    id           int         NOT NULL,
    company_name varchar(80) NOT NULL
);

