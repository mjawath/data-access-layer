package com.openworld.tech.dal.meta.model;

import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetaModel {

    private Map<String,List<Map<String, List<String>>>> globalMap= new HashMap<>();
    //<global/region/countryCode || DomainDetail>
    private Map<String, Map<String, DomainObject>> rows= new HashMap<>(); // key will be global-region-countryCode
    private Map<String, DomainObject> domainObjectMap= new HashMap<>();

    public DomainObject getDomainObject(String domainName) {
        return domainObjectMap.get(domainName);
    }

    // This method returns the TableDetail for the provided root node
    public TableDetail getTableDetailForRootNode(String rootNode) {
        if (domainObjectMap.containsKey(rootNode)) {
            DomainObject domainObject = domainObjectMap.get(rootNode);
            return domainObject.getTableDetail();
        }
        return null; // Return null if the root node is not found
    }

    // This method maps an attribute name to the corresponding column name for a specific table
    public String getColumnForAttribute(String tableName, String attributeName) {
        // Check if the tableName exists in the domainObjectMap
        if (domainObjectMap.containsKey(tableName)) {
            DomainObject domainObject = domainObjectMap.get(tableName);
            Map<String, AttributeDetail> attributeDetailMap = domainObject.getAttributeDetailMap();
            // Check if the attributeName exists in the attributeDetailMap
            if (attributeDetailMap.containsKey(attributeName)) {
                AttributeDetail attributeDetail = attributeDetailMap.get(attributeName);
                // Get the associated column detail
                ColumnDetail columnDetail = attributeDetail.getColumnDetail();
                // Retrieve the column name
                return columnDetail.getColumn();
            }
        }
        // Return null if the mapping is not found
        return null;
    }

    public void addDomainObject(DomainObject domainObject) {
        domainObjectMap.put(domainObject.getDomainName(), domainObject);
    }

    public void getDomainForCountry(String domainObject) {
        DomainObject ddd = domainObjectMap.get(domainObject);
    }
}

