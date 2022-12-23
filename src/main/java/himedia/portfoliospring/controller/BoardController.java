package himedia.portfoliospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import himedia.portfoliospring.domain.Board;
import himedia.portfoliospring.service.BoardService;

@Controller
public class BoardController {
	
	private final BoardService boardService;

	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	// 게시판 목록
	@GetMapping("/board")
	public String board(Model model) {
		model.addAttribute("boards", boardService.findAllBoard());
		return "board";
	}
	
	// 글쓰기 폼
	@GetMapping("/board/write")
	public String write() {
		return "write";
	}
	
	// 글쓰기 저장
	@PostMapping("board/write")
	public String save(@ModelAttribute Board board) {
		boardService.save(board);
		return "redirect:/board";
	}
	
	// 글 조회
	@GetMapping("board/{boardNumber}")
	public String boardDetail(@PathVariable Long boardNumber, Model model) {
		model.addAttribute("board", boardService.findByNumber(boardNumber).get());
		return "boardDetail";
	}

}
















