package com.example.demo;


import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {
	/*@Value("${spring.datasource.driverClassName}")
	private String DRIVER;
 
	@Value("${db.password}")
	private String PASSWORD;
 
	@Value("${db.url}")
	private String URL;
 
	@Value("${db.username}")
	private String USERNAME;
 
	@Value("${hibernate.dialect}")
	private String DIALECT;
 
	@Value("${hibernate.show_sql}")
	private String SHOW_SQL;
 
	@Value("${hibernate.hbm2ddl.auto}")
	private String HBM2DDL_AUTO;
 
	@Value("${entitymanager.packagesToScan}")
	private String PACKAGES_TO_SCAN;
 	*/
//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("org.h2.Driver");
//		dataSource.setUrl("jdbc:h2:mem:testdb");
//		dataSource.setUsername("sa");
//		dataSource.setPassword("password");
//		return dataSource;
//	}
	@Bean
	public DataSource dataSource() {
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/db1");
	dataSource.setUsername("root");
	dataSource.setPassword("admin");
	return dataSource;
	}
 
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.example.demo.models");
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hibernateProperties.put("hibernate.show_sql", "true");
		hibernateProperties.put("hibernate.hbm2ddl.auto", "create");
		sessionFactory.setHibernateProperties(hibernateProperties);
 
		return sessionFactory;
	}
 
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}	
	   
	
}


