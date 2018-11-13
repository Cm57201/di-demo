package guru.springframework.examplebeans;

public class FakeJmsSource {

	private String user;
	private String password;
	private String dbUrl;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	@Override
	public String toString() {
		return "FakeJmsSource [user=" + user + ", password=" + password + ", dbUrl=" + dbUrl + "]";
	}
}
