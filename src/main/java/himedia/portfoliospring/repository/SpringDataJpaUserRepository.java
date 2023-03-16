package himedia.portfoliospring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import himedia.portfoliospring.domain.User;

public interface SpringDataJpaUserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUserId(String userId);
}
