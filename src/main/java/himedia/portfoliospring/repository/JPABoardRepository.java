package himedia.portfoliospring.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import himedia.portfoliospring.domain.Board;
import lombok.RequiredArgsConstructor;

//@Repository
@RequiredArgsConstructor
@Transactional
public class JPABoardRepository implements BoardIterfaceRepository{
	
	private final EntityManager em;

	@Override
	public Board save(Board board) {
		em.persist(board);;
		return board;
	}

	@Override
	public List<Board> findAll() {
		return em.createQuery("select b from Board b", Board.class)
				.getResultList();
	}

	@Override
	public Optional<Board> findById(Long id) {
		Board board = em.find(Board.class, id);
		return Optional.ofNullable(board);
	}

	@Override
	public void update(Long id, Board updateBoard) {
		String sql = "update Board i set title=:title"
				+ ", content=:content"
				+ ", writer=:writer "
				+ " where id=:id";
		em.createQuery(sql).setParameter("title", updateBoard.getTitle())
							.setParameter("content", updateBoard.getContent())
							.setParameter("writer", updateBoard.getWriter())
							.setParameter("id", id)
							.executeUpdate();
	}

}
