package himedia.portfoliospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import himedia.portfoliospring.domain.Board;
import himedia.portfoliospring.repository.SpringDataJpaBoardRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
	private final SpringDataJpaBoardRepository boardRepository;
	
	public void save(Board board) {
		boardRepository.save(board);
	}
	
	public List<Board> findAllBoard() {
		return boardRepository.findAll();
	}
	
	public Optional<Board> findById(Long id) {
		return boardRepository.findById(id);
	}
	
//	public void update(Long number, Board upBoard) {
//		boardRepository.update(number, upBoard);
//	}

}
