package himedia.portfoliospring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import himedia.portfoliospring.domain.Board;

public interface SpringDataJpaBoardRepository extends JpaRepository<Board, Long>{
	Page<Board> findByTitleContaining(Pageable pageable, String searchKeywod);
}





