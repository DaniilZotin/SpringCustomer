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

CREATE TABLE IF NOT EXISTS developers(
   id BIGINT AUTO_INCREMENT primary key,
   role varchar(50) not null,
   experience decimal not null,
   developer_id bigint references groups_table(id)
);

CREATE TABLE IF NOT EXISTS students(
   id BIGINT AUTO_INCREMENT primary key,
   name_student varchar(50) not null
);

CREATE TABLE IF NOT EXISTS courses(
   id BIGINT AUTO_INCREMENT primary key,
   name_course varchar(50) not null
);

CREATE TABLE IF NOT EXISTS students_courses (
   student_id bigint,
   course_id bigint,
   PRIMARY KEY (student_id, course_id),
   FOREIGN KEY (student_id) REFERENCES students(id),
   FOREIGN KEY (course_id) REFERENCES courses(id)
);



