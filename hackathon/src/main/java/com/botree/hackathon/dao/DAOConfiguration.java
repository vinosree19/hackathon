package com.botree.hackathon.dao;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;


@Configuration
public class DAOConfiguration {

    /**
     * Method to read primary {@link DataSourceProperties}.
     * @return Primary {@link DataSourceProperties}
     */
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties primaryDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * Method for creating primary @link DataSource}.
     * @return Primary {@link DataSource}
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource primaryDataSource() {
        return primaryDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    /**
     * Method to read secondary {@link DataSourceProperties}.
     * @return Secondary {@link DataSourceProperties}
     */
    @Bean
    @ConfigurationProperties("spring.secondary.datasource")
    public DataSourceProperties secondaryDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * Method for creating secondary {@link DataSource}.
     * @return Secondary {@link DataSource}
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.secondary.datasource.hikari")
    public DataSource secondaryDataSource() {
        return secondaryDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    /**
     * Method to create primary {@link JdbcTemplate}.
     * @param ds Primary datasource
     * @return Primary {@link JdbcTemplate}
     */
    @Bean
    @Primary
    public JdbcTemplate primaryJdbcTemplate(final @Qualifier("primaryDataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }

    /**
     * Method to create Secondary {@link JdbcTemplate}.
     * @param ds Secondary datasource
     * @return Secondary {@link JdbcTemplate}
     */
    @Bean
    public JdbcTemplate secondaryJdbcTemplate(final @Qualifier("secondaryDataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }

    /**
     * Method to create primary {@link NamedParameterJdbcTemplate}.
     * @param ds Primary datasource
     * @return Primary {@link NamedParameterJdbcTemplate}
     */
    @Bean
    @Primary
    public NamedParameterJdbcTemplate primaryNamedJdbcTemplate(final @Qualifier("primaryDataSource") DataSource ds) {
        return new NamedParameterJdbcTemplate(ds);
    }

    /**
     * Method to create Secondary {@link NamedParameterJdbcTemplate}.
     * @param ds Secondary datasource
     * @return Secondary {@link NamedParameterJdbcTemplate}
     */
    @Bean
    public NamedParameterJdbcTemplate secondaryNamedJdbcTemplate(
            final @Qualifier("secondaryDataSource") DataSource ds) {
        return new NamedParameterJdbcTemplate(ds);
    }
}
