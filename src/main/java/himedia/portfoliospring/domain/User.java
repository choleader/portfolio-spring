package himedia.portfoliospring.domain;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

//@Entity
@Setter @Getter
public class User {
	private String userId;
	private String password;
	private String userName;
	private String birth;
	private String gender;
	private String email;
}
