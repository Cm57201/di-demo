package guru.springframework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.FakeJmsSource;
import guru.springframework.examplebeans.Pagesize;

@Configuration
//@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
@PropertySources({
	@PropertySource("classpath:datasource.properties"),
	@PropertySource("classpath:jms.properties")
})
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
	
	@Value("${guru.jms.username}")
	String jmsUser;
	
	@Value("${guru.jms.password}")
	String jmsPassword;
	
	@Value("${guru.jms.url}")
	String jmsUrl;
	
	@Value("${test.pagesize}")
	String pagesize;
	
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
	public FakeJmsSource fakeJmsBroker() {
		FakeJmsSource fjs = new FakeJmsSource();
		fjs.setUser(jmsUser);
		fjs.setPassword(jmsPassword);
		fjs.setDbUrl(jmsUrl);
		return fjs;
	}
	
	@Bean
	public Pagesize pageSize() {
		Pagesize ps = new Pagesize();
		ps.setPagesize(pagesize);
		return ps;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer properties = new PropertySourcesPlaceholderConfigurer();
		return properties;
	}
}
