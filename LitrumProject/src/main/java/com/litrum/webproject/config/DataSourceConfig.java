package com.litrum.webproject.config;

import com.litrum.webproject.dao.HibernateDAOFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
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
                com.litrum.webproject.model.ServiceOffered.class,
                com.litrum.webproject.model.CompanyType.class,
                com.litrum.webproject.model.EndUserRole.class,
                com.litrum.webproject.model.MainCategory.class,
                com.litrum.webproject.model.SubMainCategory.class,
                com.litrum.webproject.model.SubSubMainCategory.class,
                com.litrum.webproject.model.CompanyCity.class,
                com.litrum.webproject.model.AdminUserRole.class,
                com.litrum.webproject.model.AdminUserRegistration.class,
                com.litrum.webproject.model.MainItem.class,
                com.litrum.webproject.model.MainItemMaker.class,
                com.litrum.webproject.model.MainItemContractor.class,
                com.litrum.webproject.model.SubMainItem.class,
                com.litrum.webproject.model.SubMainItemMaker.class,
                com.litrum.webproject.model.SubMainItemContractor.class,
                com.litrum.webproject.model.LoadUnit.class,
                com.litrum.webproject.model.RateCity.class);
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

    @Bean
    public HibernateDAOFactory daoFactory() throws PropertyVetoException {
        HibernateDAOFactory daoFactory = new HibernateDAOFactory();
        daoFactory.setSessionFactory(sessionFactory().getObject());
        return daoFactory;
    }
}
