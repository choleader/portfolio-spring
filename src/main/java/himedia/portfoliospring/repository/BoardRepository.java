package himedia.portfoliospring.repository;

import java.util.List;
import java.util.Optional;

import himedia.portfoliospring.domain.Board;

public interface BoardRepository {
	Board save(Board board);
	List<Board> findAll();
	Optional<Board> findByNumber(Long number);
	void update(Long number, Board updateBoard);
}
