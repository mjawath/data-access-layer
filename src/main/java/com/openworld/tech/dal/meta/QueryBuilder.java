package com.openworld.tech.dal.meta;

import com.openworld.tech.dal.meta.model.MetaModel;
import com.openworld.tech.dal.meta.model.TableDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryBuilder {

    @Autowired
    private QueryValidator queryValidator;

    private int aliasCounter = 0; //  counter for table alias

    public String buildQuery(MetaModel metaModel, String rootNode, String... selectedFields) {
        aliasCounter = 0;//reset the counter

        // Use the QueryValidator to perform validation
        if (!queryValidator.isValidQuery(metaModel, rootNode, selectedFields)) {
            throw new IllegalArgumentException("Invalid query");
        }
        //"SELECT SHIPMENT_1.ID,SHIPMENT_1.AWB_NUMBER FROM SHIPMENT SHIPMENT_1 WHERE SHIPMENT_1.ID = :id AND SHIPMENT_1.AWB_NUMBER = :awbNumber"
        StringBuilder query = new StringBuilder("SELECT ");

        TableDetail tableDetail = metaModel.getTableDetailForRootNode(rootNode);
        String tableAlias = generateTableAlias(tableDetail.getTableName());

        // Iterate through the selectedFields and build the SELECT clause
        // Map attribute names to column names based on the MetaModel
        for (String attributeName : selectedFields) {
            // Retrieve the corresponding column name from the MetaModel
            String columnName = metaModel.getColumnForAttribute(rootNode, attributeName);
            if (columnName != null) {
                query.append(tableAlias).append(".").append(columnName).append(", ");
            }
        }
        // Remove the trailing comma and space
        query.deleteCharAt(query.length() - 2);

        // Append the FROM clause
        query.append(" FROM ").append(tableDetail.getTableName()).append(" AS ").append(tableAlias);

        // You may need to generate JOIN clauses here if there are relationships between tables

        return query.toString();
    }

    // Helper method to generate a table alias from the table name
    private String generateTableAlias(String tableName) {
        return tableName.toUpperCase() + "_" + aliasCounter;
    }
}
