drop table if exists board cascade;

create table if not exists board (
id bigint auto_increment,
title varchar(255),
content  varchar(255),
writer varchar(255),
created_date datetime NOT NULL DEFAULT current_timestamp() COMMENT 'μμ±μΌμ',
constraint pk_number primary key (id)
);