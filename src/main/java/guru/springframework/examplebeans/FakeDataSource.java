package guru.springframework.examplebeans;

public class FakeDataSource {

	private String user;
	private String env_username;
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

	public String getEnv_username() {
		return env_username;
	}

	public void setEnv_username(String env_username) {
		this.env_username = env_username;
	}

	@Override
	public String toString() {
		return "FakeDataSource [user=" + user + ", env_username=" + env_username + ", password=" + password + ", dbUrl="
				+ dbUrl + "]";
	}


}
