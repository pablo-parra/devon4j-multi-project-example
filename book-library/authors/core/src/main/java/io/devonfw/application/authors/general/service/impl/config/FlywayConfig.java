package io.devonfw.application.authors.general.service.impl.config;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for the Flyway instance of the Authors service
 *
 */
@Configuration
public class FlywayConfig {

  /** Property is true if database migration is enabled. */
  @Value("${authors.flyway.enabled}")
  private boolean flywayEnabled;

  /** Path of data location. */
  @Value("${authors.flyway.locations}")
  private String flywayScriptsLocation;

  /** The JDBC data source. */
  @Autowired
  @Qualifier("authorsDataSource")
  private DataSource dataSource;

  /** Property is true if database should be cleaned before migration. */
  private boolean clean;

  /**
   * Migrate the database to the latest available migration.
   */
  @PostConstruct
  public void migrate() {

    if (this.flywayEnabled) {
      final Flyway flyway = new Flyway();
      flyway.setDataSource(this.dataSource);
      flyway.setLocations(this.flywayScriptsLocation);

      if (this.clean) {
        flyway.clean();
      }
      flyway.migrate();
    }
  }
}
