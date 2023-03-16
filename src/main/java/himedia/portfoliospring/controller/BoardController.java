package himedia.portfoliospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import himedia.portfoliospring.domain.Board;
import himedia.portfoliospring.service.BoardService;

@Controller
public class BoardController {
	private final BoardService boardService;

	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@GetMapping("/board")
	public String board(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
			String searchKeyword, Model model) {

		Page<Board> board = null;

		if (searchKeyword == null) {
			board = boardService.findAllBoard(pageable);
		} else {
			board = boardService.boardSearchList(searchKeyword, pageable);
		}

		int startPage = (board.getNumber() / 10) * 10 + 1;
		int endPage = startPage + 9 < board.getTotalPages() ? startPage + 9 : board.getTotalPages();

		model.addAttribute("searchKeyword", searchKeyword);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("boards", board);
		return "board";
	}

	@GetMapping("/board/write")
	public String write() {
		return "write";
	}

	@PostMapping("/board/write")
	public String save(@ModelAttribute Board board) {
		boardService.save(board);
		return "redirect:/board";
	}

	@GetMapping("/board/{boardId}")
	public String boardDetail(@PathVariable Long boardId, Model model) {
		model.addAttribute("board", boardService.findById(boardId).get());
		return "boardDetail";
	}

	@GetMapping("/board/{boardId}/edit")
	public ModelAndView editForm(@PathVariable Long boardId) {
		ModelAndView mv = new ModelAndView("boardEdit");
		mv.addObject("board", boardService.findById(boardId).get());
		return mv;
	}

	@PostMapping("/board/{boardId}")
	public ModelAndView edit(@PathVariable Long boardId, @ModelAttribute Board updateBoard) {
		ModelAndView mv = new ModelAndView("boardDetail");
		boardService.update(boardId, updateBoard);
		mv.addObject("board", updateBoard);
		return mv;
	}

	@GetMapping("/board/{boardId}/remove")
	public String boardRemove(@PathVariable Long boardId) {
		boardService.removeBoard(boardId);
		return "redirect:/board";
	}
}




















