package io.devonfw.application.books.general.service.impl.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuration class for the DB connection of the Books service
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "booksEntityManagerFactory", transactionManagerRef = "booksTransactionManager", basePackages = {
"io.devonfw.application.books" })
public class BooksDbConfig {

  @Primary
  @Bean(name = "booksDataSource")
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource dataSource() {

    return DataSourceBuilder.create().build();
  }

  @Primary
  @Bean(name = "booksEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
      @Qualifier("booksDataSource") DataSource dataSource) {

    return builder.dataSource(dataSource).packages("io.devonfw.application.books").persistenceUnit("books").build();
  }

  @Primary
  @Bean(name = "booksTransactionManager")
  public PlatformTransactionManager transactionManager(
      @Qualifier("booksEntityManagerFactory") EntityManagerFactory entityManagerFactory) {

    return new JpaTransactionManager(entityManagerFactory);
  }

}
