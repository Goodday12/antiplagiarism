
package com.development5053.antiplagiarism.model.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;



@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.development5053.antiplagiarism.model.dao")
@PropertySource("classpath:database.properties")
public class DataConfig {

    /** Here we define environment that use property file */
    private final Environment environment;

    public DataConfig(Environment environment) {
        this.environment = environment;
    }

    /** connecting to database */
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(environment.getProperty("db.driver"));
        dataSource.setUsername(environment.getProperty("db.username"));
        dataSource.setPassword(environment.getProperty("db.password"));
        dataSource.setUrl(environment.getProperty("db.url"));

        return dataSource;
    }

    @Bean
    public JpaVendorAdapter vendorAdapter(){
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        vendorAdapter.setShowSql(true);
        vendorAdapter.setDatabase(Database.MYSQL);

        return vendorAdapter;
    }

    /** here we configure entityManagerFactory with all we've done before */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        Properties properties = new Properties();

        entityManagerFactory.setJpaVendorAdapter(vendorAdapter());
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPackagesToScan(environment.getProperty("db.packageToScan"));

        properties.put(environment.getProperty("db.hibernate.hbm2ddl"),
                environment.getProperty("db.hibernate.hbm2ddl.values"));

        entityManagerFactory.setJpaProperties(properties);
        return entityManagerFactory;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }

}

