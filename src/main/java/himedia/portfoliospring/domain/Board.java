package himedia.portfoliospring.domain;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Board {
	private Long number;
	private String title;
	private String content;
	private String writer;
}
