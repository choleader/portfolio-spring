drop table if exists item cascade;

create table if not exists board (
id bigint auto_increment,
title varchar(255),
content  varchar(255),
writer varchar(255),
constraint pk_number primary key (id)
);