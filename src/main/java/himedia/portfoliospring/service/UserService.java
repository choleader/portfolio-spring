package himedia.portfoliospring.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import himedia.portfoliospring.domain.UserDto;
import himedia.portfoliospring.repository.SpringDataJpaUserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final SpringDataJpaUserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public Long join(UserDto userDto) {
		userDto.encoderPassword(passwordEncoder);
		userRepository.save(userDto.toEntity());
		return userDto.toEntity().getUserNumber();
	}
	
	public Boolean login(UserDto userDto) {
		String encodePw = userRepository.findByUserId(userDto.getUserId()).get().getPassword();
		String rawPw = userDto.getPassword1();
		return passwordEncoder.matches(rawPw, encodePw);
	}
	
}
