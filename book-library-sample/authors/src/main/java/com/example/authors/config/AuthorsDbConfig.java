package com.example.authors.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Config class for the DB connection of the Authors service
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "authorsEntityManagerFactory", transactionManagerRef = "authorsTransactionManager", basePackages = {
"com.example.authors" })
public class AuthorsDbConfig {

  @Bean(name = "authorsDataSource")
  @ConfigurationProperties(prefix = "authors.datasource")
  public DataSource dataSource() {

    return DataSourceBuilder.create().build();
  }

  @Bean(name = "authorsEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean authorsEntityManagerFactory(EntityManagerFactoryBuilder builder,
      @Qualifier("authorsDataSource") DataSource dataSource) {

    return builder.dataSource(dataSource).packages("com.example.authors").persistenceUnit("authors").build();
  }

  @Bean(name = "authorsTransactionManager")
  public PlatformTransactionManager authorsTransactionManager(
      @Qualifier("authorsEntityManagerFactory") EntityManagerFactory authorsEntityManagerFactory) {

    return new JpaTransactionManager(authorsEntityManagerFactory);
  }
}
