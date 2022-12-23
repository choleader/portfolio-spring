package himedia.portfoliospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.portfoliospring.domain.Board;
import himedia.portfoliospring.repository.JdbcBoardRepository;

@Service
public class BoardService {
	private final JdbcBoardRepository boardRepository;
	
	@Autowired
	public BoardService(JdbcBoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}
	
	public void save(Board board) {
		boardRepository.save(board);
	}
	
	public List<Board> findAllBoard() {
		return boardRepository.findAll();
	}
	
	public Optional<Board> findByNumber(Long number) {
		return boardRepository.findByNumber(number);
	}

}
