package com.niit.hibernet;


import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement

@ComponentScan(basePackages={"com.niit.hibernet"})
//@PropertySource(value = { "classpath:application.properties" })
public class hibernetconfig {


	/**
	 * 
	 */

	/**
	 * Initialize dataSource 
	 * @return DataSource
	 */@Autowired
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test3");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}

	/**
	 * Initialize hibernate properties 
	 * @return Properties
	 */
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.connection.url", "jdbc:h2:tcp://localhost/~/test3");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.format_sql","true");
		return properties;
	}

	/**
	 * Initialize SessionFactory 
	 * @return LocalSessionFactoryBean
	 */
	@Autowired
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.niit.model" });
		sessionFactory.setHibernateProperties(getHibernateProperties());
		return sessionFactory;
	}

	/**
	 * Initialize Transaction Manager 
	 * @param sessionFactory
	 * @return HibernateTransactionManager
	 */
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}
}

