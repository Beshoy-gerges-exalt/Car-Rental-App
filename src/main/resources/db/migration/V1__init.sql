CREATE TABLE car
(
    id            int(20)     not null AUTO_INCREMENT,
    customer_name varchar(50),
    rent_end_date date,
    name          varchar(50) not null,
    updated_at    datetime    not null default current_timestamp,
    created_at    datetime    not null default current_timestamp,
    primary key (id)
)