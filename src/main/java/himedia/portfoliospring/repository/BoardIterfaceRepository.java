package himedia.portfoliospring.repository;

import java.util.List;
import java.util.Optional;

import himedia.portfoliospring.domain.Board;

public interface BoardIterfaceRepository {
	Board save(Board board);
	List<Board> findAll();
	Optional<Board> findById(Long id);
	void update(Long id, Board updateBoard);
}
