package com.openworld.tech.dal.meta.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

//@Component
public class MetaQueryBuilder {

    //some how load this from config
    private Map<String,String> map;

    @Autowired
    private MappingConfiguration mappingConfiguration;

    public String buildQuery(String countryCode, String queryName) {
        return map.get(queryName);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<String> buildQuery(List<String> selectedAttributes) {
        StringBuilder queryBuilder = new StringBuilder("SELECT ");


        for (String attribute : selectedAttributes) {
            switch (attribute) {
                case "id":
                    queryBuilder.append("shipment.id, ");
                    break;
                case "location":
                    queryBuilder.append("shipment.location, ");
                    break;
                case "customer.id":
                    queryBuilder.append("customer.id, ");
                    break;
                case "customer.name":
                    queryBuilder.append("customer.name, ");
                    break;
                // Add more cases for other attributes
            }
        }

        // Remove the trailing comma and space
        queryBuilder.setLength(queryBuilder.length() - 2);

        queryBuilder.append(" FROM shipment ");
        queryBuilder.append("INNER JOIN customer ON shipment.customer_id = customer.id");

        String sql = queryBuilder.toString();

        return jdbcTemplate.queryForList(sql, String.class);
    }
}

