package himedia.portfoliospring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
	@Column(name="user_number")
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userNumber;
	@Column(name="user_id")
	private String userId;
	private String password;
	@Column(name="user_name")
	private String userName;
	private String email;
	private String birth;
	private String gender;
    @Enumerated(EnumType.STRING)
    private Role role;
}
