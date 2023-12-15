create TABLE client
(
    id          int         NOT NULL,
    client_name varchar(80) NOT NULL,
    place       varchar(80) NOT NULL,
    email       varchar(80),
    company_id  int         not null
);
