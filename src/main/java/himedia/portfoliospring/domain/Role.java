package himedia.portfoliospring.domain;

public enum Role {
	
	ROLE_MEMBER("일반사용자");

	private final String value; 
	
	Role(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
