package himedia.portfoliospring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import himedia.portfoliospring.domain.Board;
import himedia.portfoliospring.repository.SpringDataJpaBoardRepository;
import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class BoardService {
	private final SpringDataJpaBoardRepository boardRepository;
	
	public Long save(Board board) {
		boardRepository.save(board);
		return board.getId();
	}
	
	public List<Board> findAllBoard() {
		return boardRepository.findAll();
	}
	
	public Page<Board> findAllBoard(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}
	
    public Page<Board> boardSearchList(String searchKeyword,Pageable pageable){
        return boardRepository.findByTitleContaining(pageable, searchKeyword);
    }
    
	
	public Optional<Board> findById(Long id) {
		return boardRepository.findById(id);
	}
	
	public void update(Long id, Board updateBoard) {
		Optional<Board> board = boardRepository.findById(id);
		board.get().setTitle(updateBoard.getTitle());
		board.get().setContent(updateBoard.getContent());
	}
	
	public void removeBoard(Long id) {
		boardRepository.delete(findById(id).get());
	}
}
