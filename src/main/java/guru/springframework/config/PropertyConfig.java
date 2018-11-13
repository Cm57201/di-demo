package guru.springframework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import guru.springframework.examplebeans.FakeDataSource;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {

	/* Will bring back os environment variables*/
	@Autowired
	Environment env;
	
	@Value("${guru.username}")
	String user;
	
	@Value("${guru.password}")
	String password;
	
	@Value("${guru.dburl}")
	String dbUrl;
	
	@Bean
	public FakeDataSource fakeDataSource() {
		FakeDataSource fakeDataSource = new FakeDataSource();
		fakeDataSource.setUser(user);
		fakeDataSource.setPassword(password);
		fakeDataSource.setDbUrl(dbUrl);
		fakeDataSource.setEnv_username(env.getProperty("username"));
		return fakeDataSource;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer properties = new PropertySourcesPlaceholderConfigurer();
		return properties;
	}
}
