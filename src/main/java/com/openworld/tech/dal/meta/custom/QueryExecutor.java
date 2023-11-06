package com.openworld.tech.dal.meta.custom;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class QueryExecutor {

    @Autowired
    private JPAQueryBuilder JPAQueryBuilder;

    public Map<String, Object> executeQuery(String queryId, String rootNode, Map<String, Object> params) {
        String query = JPAQueryBuilder.buildQuery(queryId, rootNode, params);
//        jdbcTemplate
        return null;
    }

    // node level query
    public Map<String, Object> executeQuery(String rootNode, Map<String, Object> params) {
//        String query = this.executeQuery( rootNode, params);


        return null;
    }
}