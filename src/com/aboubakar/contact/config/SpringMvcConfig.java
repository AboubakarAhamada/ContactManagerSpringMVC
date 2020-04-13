package com.aboubakar.contact.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.aboubakar.contact.dao.ContactDao;
import com.aboubakar.contact.dao.ContactDaoImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.aboubakar.contact")
public class SpringMvcConfig {
	
	@Bean
	public DataSource getDataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/db_example?serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("aboubakar");
		
		return dataSource;
	}
	
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public ContactDao getContactDao() {
		return new ContactDaoImpl(getDataSource());
	}
}
