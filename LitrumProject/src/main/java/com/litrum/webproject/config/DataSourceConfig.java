package com.litrum.webproject.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

/**
 * Created by Pc on 21/03/2017.
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:litrumProject.properties")
public class DataSourceConfig {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(DataSourceConfig.class);
    private static final String DRIVER_CLASS = "hibernate.connection.driver_class";
    private static final String JDBC_URL = "hibernate.connection.database.url";
    private static final String USER_NAME = "hibernate.connection.database.username";
    private static final String PASS_WORD = "hibernate.connection.database.password";
    private static final String HIBERNATE_DIALECT = "hibernate.dialect";

    @Autowired
    private Environment environment;

    @Bean
    public DataSource serverDataSource() throws PropertyVetoException {
        ComboPooledDataSource serverDataSource = new ComboPooledDataSource();
        serverDataSource.setDriverClass(environment.getProperty(DRIVER_CLASS));
        serverDataSource.setJdbcUrl(environment.getProperty(JDBC_URL));
        serverDataSource.setUser(environment.getProperty(USER_NAME));
        serverDataSource.setPassword(environment.getProperty(PASS_WORD));
        return serverDataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setHibernateProperties(getHibernateProperty());
        sessionFactory.setAnnotatedClasses(com.litrum.webproject.model.PersistentObject.class,
                com.litrum.webproject.model.EndUserRegistration.class,
                com.litrum.webproject.model.CompanyDetails.class,
                com.litrum.webproject.model.ServiceOffered.class,
                com.litrum.webproject.model.CompanyType.class,
                com.litrum.webproject.model.EndUserRole.class);
        sessionFactory.setDataSource(serverDataSource());
        return sessionFactory;
    }

    private Properties getHibernateProperty() {
        Properties properties = new Properties();
        properties.put(HIBERNATE_DIALECT, environment.getProperty(HIBERNATE_DIALECT));
        return properties;
    }

    @Bean
    HibernateTransactionManager transactionManager() throws PropertyVetoException {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
