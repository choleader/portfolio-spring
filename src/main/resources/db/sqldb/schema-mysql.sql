drop table if exists board cascade;
drop table if exists user cascade;

create table if not exists board (
id bigint auto_increment,
title varchar(50),
content  varchar(200),
writer varchar(20),
searchKeyword varchar(100),
created_date datetime NOT NULL DEFAULT current_timestamp() COMMENT '생성일시',
constraint pk_number primary key (id)
);


create table if not exists user (
user_id varchar(50),
user_number bigint auto_increment,
user_name varchar(50),
password varchar(100),
birth date,
gender varchar(10),
email varchar(100),
role varchar(20),
primary key(user_number)
);