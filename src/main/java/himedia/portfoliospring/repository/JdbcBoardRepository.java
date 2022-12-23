package himedia.portfoliospring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import himedia.portfoliospring.domain.Board;

@Repository
public class JdbcBoardRepository implements BoardRepository {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcBoardRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private RowMapper<Board> itemRowMapper() {
		return new RowMapper<Board>() {
			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board = new Board();
				board.setNumber(rs.getLong("number"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				return board;
			}
		};
	}

	// 저장
	@Override
	public Board save(Board board) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		jdbcInsert.withTableName("board").usingGeneratedKeyColumns("number");

		Map<String, String> parameter = new HashMap<>();
		parameter.put("title", board.getTitle());
		parameter.put("content", String.valueOf(board.getContent()));

		Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameter));

		board.setNumber(key.longValue());
		return board;
	}

	// 전체 조회
	@Override
	public List<Board> findAll() {
		return jdbcTemplate.query("select * from board", itemRowMapper());
	}

	// number로 조회
	@Override
	public Optional<Board> findByNumber(Long number) {
		return jdbcTemplate.query("select * from board where number = ?", itemRowMapper(), number).stream().findAny();
	}

}
