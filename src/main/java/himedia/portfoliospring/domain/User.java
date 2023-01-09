package himedia.portfoliospring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

//@Entity
@Setter @Getter
public class User {
	@Column(name="user_id")
	private String userId;
	private String password;
	@Column(name="user_name")
	private String userName;
	private String birth;
	private String gender;
	private String email;
}
