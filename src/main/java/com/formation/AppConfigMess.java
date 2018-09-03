package com.formation;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import com.formation.service.IMessageService;
import com.formation.service.MessageToDatabaseService;
import com.formation.user.ChatConsole;
import com.jdbc.MariaDBConfig;

@Configuration
@Import(MariaDBConfig.class)
public class AppConfigMess {

	private DataSource dataSource;

	@Bean
	public ChatConsole useBean() {
		return new ChatConsole("Flora");
	}

	@Autowired
	public AppConfigMess(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Bean
	public JdbcTemplate simpleJdbcSample() {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public IMessageService service() {
		return new MessageToDatabaseService();
	}

}