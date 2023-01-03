package himedia.portfoliospring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
/*
MySQL 

## 테이블 생성 
create table if not exists board (
number bigint auto_increment,
title varchar(255),
content  varchar(255),
writer varchar(255),
constraint pk_number primary key (number)
);

 */

@Entity
@Setter @Getter
@Table(name = "board")
public class Board {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String content;
	private String writer;
}



















