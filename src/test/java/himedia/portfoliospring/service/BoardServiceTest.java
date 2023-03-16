package himedia.portfoliospring.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import himedia.portfoliospring.domain.Board;

@Transactional
@SpringBootTest
class BoardServiceTest {
	
	@Autowired BoardService boardService;

	@Test
	void save() {
		Board board = new Board();
		board.setWriter("조상연");
		board.setContent("안녕");
		
		Long saveId = boardService.save(board);
		
		assertThat(saveId).isEqualTo(board.getId());
	}
	
	@Test
	void findAllBoard() {
		List<Board> before = boardService.findAllBoard();
		
		Board board = new Board();
		boardService.save(board);
		
		List<Board> after = boardService.findAllBoard();
		
		assertThat(after.size()-1).isEqualTo(before.size());
	}
	
	@Test
	void findById() {
		Board board = new Board();
		boardService.save(board);
		
		Board saveBoard =  boardService.findById(board.getId()).get();
		
		assertThat(saveBoard).isEqualTo(board);
	}
	
	@Test
	void update() { 
		Board board = new Board();
		board.setTitle("안녕");
		board.setContent("잘부탁해");
		boardService.save(board);
		
		Board updateBoard = new Board();
		updateBoard.setTitle("hi");
		updateBoard.setContent("nice to meet you");
		boardService.update(board.getId(), updateBoard);
		
		assertThat(board.getTitle()).isEqualTo(updateBoard.getTitle());
	}
	
	@Test 
	void removeBoard() {
		Board board = new Board();
		boardService.save(board);
		
		boardService.removeBoard(board.getId());
		
		Optional<Board> testBoard = boardService.findById(board.getId());
		
		assertThat(testBoard).isEqualTo(Optional.empty());
	}
	
	
}

















