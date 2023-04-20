CREATE TABLE IF NOT EXISTS customers(
    id BIGINT AUTO_INCREMENT primary key,
    first_name varchar(50) not null,
    last_name varchar(50) not null ,
    address varchar(1000) not null ,
    budget decimal not null
);
CREATE TABLE IF NOT EXISTS orders(
    id BIGINT AUTO_INCREMENT primary key,
    goods varchar(50) not null,
    date varchar(50) not null,
    prise decimal not null,
    customer_id bigint references customers(id)
);

CREATE TABLE IF NOT EXISTS groups_table(
    id BIGINT AUTO_INCREMENT primary key,
    name_group varchar(50) not null,
    community decimal not null
);



