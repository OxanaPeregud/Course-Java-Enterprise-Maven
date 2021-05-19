create table person
(
    person_id  int auto_increment
        primary key,
    first_name varchar(20) not null,
    last_name  varchar(20) not null,
    age        int         not null
);

create table address
(
    address_id int auto_increment
        primary key,
    street     varchar(20) not null,
    house      int         not null,
    apartment  int         not null
);

create table person_address
(
    id                 int auto_increment
        primary key,
    person_person_id   int not null,
    address_address_id int not null
);
