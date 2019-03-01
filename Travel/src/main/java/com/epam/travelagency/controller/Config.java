package com.epam.travelagency.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.epam.travelagency.bean.Tour;
import com.epam.travelagency.dao.DAOFactory;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement

public class Config {



	@Bean(name = "DAOFactory")
	public DAOFactory factory() {
		return new DAOFactory();
	}

	@Bean(name = "hikariConfig")
	HikariConfig config() {
		return new HikariConfig("/hikaricp.properties");
	}

	@Bean(name = "hikariDataSource")
	HikariDataSource source() {

		return new HikariDataSource(config());
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager txManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(source());
		return transactionManager;
	}

	@Bean(name = "Tour")
	@Scope("prototype")
	Tour tour() {
		return new Tour();
	}

	

	
	


}
