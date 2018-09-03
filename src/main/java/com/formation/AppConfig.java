package com.formation;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.formation.user.UserInteraction;

@Configuration
public class AppConfig {

	private DataSource dataSource;

	@Bean
	public UserInteraction useBean() {
		return new UserInteraction();
	}

	@Autowired
	public AppConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Bean
	public JdbcTemplate simpleJdbcSample() {
		return new JdbcTemplate(dataSource);
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}