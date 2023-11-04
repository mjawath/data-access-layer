package com.openworld.tech.dal.meta.custom;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class QueryBuilder {


    @Autowired
    private MappingConfiguration mappingConfiguration;

    public String buildQuery(String queryId, String rootNode, Map<String, Object> params) {
        return " SELECT ";
    }

    public String buildQuery(List<String> selectedAttributes, String queryId, String rootNode) {
        if (!mappingConfiguration.containsEntityMapping(queryId)) {
            throw new IllegalArgumentException("Entity mapping not found for: " + queryId);
        }

        Map<String, String> attributeToColumnMapping = mappingConfiguration.getEntityAttributeToColumnMapping(queryId);

        StringBuilder queryBuilder = new StringBuilder("SELECT ");

        for (String attribute : selectedAttributes) {
            if (!attributeToColumnMapping.containsKey(attribute)) {
                throw new IllegalArgumentException("Attribute not found in mapping: " + attribute);
            }

            queryBuilder.append(attributeToColumnMapping.get(attribute)).append(", ");
        }

        queryBuilder.setLength(queryBuilder.length() - 2); // Remove trailing comma and space

        queryBuilder.append(" FROM ").append(attributeToColumnMapping.get(queryId));

        String sql = queryBuilder.toString();

        return sql;

    }
}