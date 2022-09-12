package com.botree.hackathon.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class DAORepository {

    /** namedJdbcTemplate. Primary write operation. */
    private final NamedParameterJdbcTemplate namedJdbcTemplate;

    /** jdbcTemplate. Secondary read operation. */
    private final JdbcTemplate secondaryJdbcTemplate;

    /** NamedParameterJdbcTemplate. Secondary read operation. */
    private final NamedParameterJdbcTemplate secondaryNamedJdbcTemplate;

    /**
     * This constructor is used for constructor injection.
     * @param namedJdbcTemplateIn          Named JDBC template
     * @param secondaryJdbcTemplateIn      Secondary JDBC template
     * @param secondaryNamedJdbcTemplateIn Secondary Named JDBC template
     */
    public DAORepository(final @Qualifier("primaryNamedJdbcTemplate") NamedParameterJdbcTemplate namedJdbcTemplateIn,
                         final @Qualifier("secondaryJdbcTemplate") JdbcTemplate secondaryJdbcTemplateIn,
                         final @Qualifier("secondaryNamedJdbcTemplate")
                                 NamedParameterJdbcTemplate secondaryNamedJdbcTemplateIn) {
        this.namedJdbcTemplate = namedJdbcTemplateIn;
        this.secondaryJdbcTemplate = secondaryJdbcTemplateIn;
        this.secondaryNamedJdbcTemplate = secondaryNamedJdbcTemplateIn;
    }

    /**
     * Method to fetch the respective data.
     * @param <T>    class type
     * @param query  query
     * @param params params
     * @param clazz  class
     * @return response
     */
    public <T> T queryForObject(final String query, final Class<T> clazz, final Object... params) {
        return secondaryJdbcTemplate.queryForObject(query, clazz, params);
    }

    /**
     * This method is query for a single object.
     * @param sql    SQL query
     * @param clazz  class
     * @param params query parameters
     * @param <T>    class type
     * @return Object
     */
    public <T> T queryForObjectWithRowMapper(final String sql, final Class<T> clazz, final Object... params) {
        return secondaryJdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(clazz), params);
    }

    /**
     * Method to insert the record.
     * @param query query
     * @param obj   obj
     */
    @Transactional
    public void insert(final String query, final Object obj) {
        List<SqlParameterSource> parameters = new ArrayList<>();
        parameters.add(new BeanPropertySqlParameterSource(obj));
        namedJdbcTemplate.batchUpdate(query, parameters.toArray(new SqlParameterSource[0]));
    }

    /**
     * Method to insert the bulk records.
     * @param query query
     * @param list  list
     */
    @Transactional
    public void bulkInsert(final String query, final List<?> list) {
        saveOrUpdate(query, list);
    }

    /**
     * This method updateStatus is used to update the process details with status,
     * start time and end time to complete the process.
     * @param query  query
     * @param params params
     * @return query update status
     */
    public Integer updateStatus(final String query, final MapSqlParameterSource params) {
        return namedJdbcTemplate.update(query, params);
    }

    /**
     * Method to update the status.
     * @param query query
     * @param list  list
     */
    @Transactional
    public void updateStatus(final String query, final List<?> list) {
        saveOrUpdate(query, list);
    }

    /**
     * Method to save or update.
     * @param query query
     * @param list  list
     */
    private void saveOrUpdate(final String query, final List<?> list) {
        var batch = SqlParameterSourceUtils.createBatch(list.toArray());
        namedJdbcTemplate.batchUpdate(query, batch);
    }

    /**
     * Method to fetch the data.
     * @param query  query
     * @param params params
     * @param clazz  clazz
     * @param <T>    type
     * @return list
     */
    public <T> List<T> fetchData(final String query, final MapSqlParameterSource params, final Class<T> clazz) {
        return secondaryNamedJdbcTemplate.query(query, params, new BeanPropertyRowMapper<>(clazz));
    }

    /**
     * Method to fetch the data.
     * @param query  query
     * @param params params
     * @param clazz  clazz
     * @param <T>    type
     * @return list
     */
    public <T> List<T> queryForList(final String query, final Map<String, Object> params, final Class<T> clazz) {
        return secondaryNamedJdbcTemplate.query(query, params, new BeanPropertyRowMapper<>(clazz));
    }

    /**
     * Method to fetch the data.
     * @param query  query
     * @param clazz  clazz
     * @param params params
     * @param <T>    type
     * @return list
     */
    public <T> List<T> queryForListWithRowMapper(final String query, final Class<T> clazz, final Object... params) {
        return secondaryJdbcTemplate.query(query, new BeanPropertyRowMapper<>(clazz), params);
    }

    /**
     * Method to fetch the data.
     * @param sql    sql
     * @param params params
     * @return list
     */
    public List<Map<String, Object>> queryForList(final String sql, final Map<String, Object> params) {
        return secondaryNamedJdbcTemplate.queryForList(sql, params);
    }
}
