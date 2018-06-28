package org.product.controller;

import java.sql.SQLException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.sql.DataSource;

import org.h2.server.web.WebServlet;
import org.h2.tools.Server;
import org.product.ProductApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
//@EnableJpaRepositories(basePackages = "org.product.persistence.dao")
@PropertySource("application.properties")
@EnableTransactionManagement
public class MyApplicationTest extends ProductApplication {
//	
//	@Autowired
//    private Environment env;
//
//
//	@Bean
//	@ConfigurationProperties(prefix="application.properties")
//	public DataSource dataSource() {
//	    return new EmbeddedDatabaseBuilder().
//	            setType(EmbeddedDatabaseType.H2).
//	            addScript("script.sql").
//	            //addScript("db-test-data.sql").
//	            build();
//	}
//	
//	@Bean
//    public JdbcTemplate jdbcTemplate() {
//       return new JdbcTemplate(dataSource());
//    }
//	
//	 @Bean(initMethod = "start", destroyMethod = "stop")
//	    public Server h2WebServer() throws SQLException {
//	        return Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082");
//	    }
//
//	    @Bean(initMethod = "start", destroyMethod = "stop")
//	    @DependsOn("h2WebServer")
//	    public Server h2Server() throws SQLException {
//	        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
//	    }
//	    
//	    @Bean
//	    @DependsOn("h2Server")
//	    public DataSource datasource() {
//	        HikariDataSource ds = new HikariDataSource();
//	        ds.setDriverClassName("org.h2.Driver");
//	        ds.setJdbcUrl("jdbc:h2:tcp://localhost/~/testdb");
//	        return ds;
//	    }
	

	@Autowired
    private Environment env;
     
    @Bean
    public DataSource dataSourceFor() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.pass"));
 
        return dataSource;
    }
     
    // configure entityManagerFactory
     
    // configure transactionManager
 
    // configure additional Hibernate Properties

    
}
