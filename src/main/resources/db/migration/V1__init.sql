CREATE TABLE customer
(
    id         int(20) AUTO_INCREMENT,
    name       varchar(50),
    email      varchar(50) unique not null,
    updated_at datetime           not null default current_timestamp,
    created_at datetime           not null default current_timestamp,
    primary key (id)
);

CREATE TABLE car
(
    id            int(20) AUTO_INCREMENT,
    name          varchar(50) not null,
    customer_id   int(20),
    rent_end_date date,
    updated_at    datetime    not null default current_timestamp,
    created_at    datetime    not null default current_timestamp,
    primary key (id),
    foreign key (customer_id) references customer (id)
);
