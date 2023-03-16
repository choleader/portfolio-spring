package himedia.portfoliospring.domain;


import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDto {
	private Long userNumber;
	private String userId;
	private String password1;
	private String password2;
	private String userName;
	private String email;
	private String birth;
	private String gender;
	private Role role;
	private int yyyy;
	private int mm;
	private int dd;
	
	public User toEntity() {
		User user = User.builder().userNumber(userNumber)
											.userId(userId)
											.password(password1)
											.userName(userName)
											.email(email)
											.birth(yyyy+"-"+mm+"-"+dd)
											.gender(gender)
											.role(Role.ROLE_MEMBER)
											.build();
		return user;
	}
	
	public void encoderPassword(PasswordEncoder passwordEncoder) {
		this.password1 = passwordEncoder.encode(password1);
		this.password2 = passwordEncoder.encode(password2);
	}
}
