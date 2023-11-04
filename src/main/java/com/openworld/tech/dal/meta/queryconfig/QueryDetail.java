package com.openworld.tech.dal.meta.queryconfig;

import java.util.Arrays;
import java.util.List;

public class QueryDetail {

    private String country;
    private String nodeName;
    private String entityClass;//with package
    private String queryId;
    private String query;
    private String selectedAttributesAsString;
    private List<String> selectedAttributes;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(String entityClass) {
        this.entityClass = entityClass;
    }

    public String getQueryId() {
        return queryId;
    }

    public void setQueryId(String queryId) {
        this.queryId = queryId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getSelectedAttributesAsString() {
        return selectedAttributesAsString;
    }

    public void setSelectedAttributesAsString(String selectedAttributesAsString) {
        this.selectedAttributesAsString = selectedAttributesAsString;
        if (selectedAttributesAsString != null && selectedAttributesAsString.length() > 0) {
            selectedAttributes = Arrays.asList(selectedAttributesAsString.split(","));
        }
    }

    public List<String> getSelectedAttributes() {
        return selectedAttributes;
    }

    public void setSelectedAttributes(List<String> selectedAttributes) {
        this.selectedAttributes = selectedAttributes;
    }
}
