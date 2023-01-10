drop table if exists board cascade;

create table if not exists board (
id bigint auto_increment,
title varchar(50),
content  varchar(200),
writer varchar(20),
searchKeyword varchar(100),
created_date datetime NOT NULL DEFAULT current_timestamp() COMMENT '생성일시',
constraint pk_number primary key (id)
);