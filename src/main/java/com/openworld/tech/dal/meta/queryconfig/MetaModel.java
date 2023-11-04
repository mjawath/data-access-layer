package com.openworld.tech.dal.meta.queryconfig;

import java.util.List;

public class MetaModel {

    public List<DomainObject> getDomainObjects() {
        return domainObjects;
    }

    public void setDomainObjects(List<DomainObject> domainObjects) {
        this.domainObjects = domainObjects;
    }

    private List<DomainObject> domainObjects;
}


 class DomainObject {
    private String nodeName;
    private String entityClass;
    private List<NamedQuery> namedQueries;

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

     public List<NamedQuery> getNamedQueries() {
         return namedQueries;
     }

     public void setNamedQueries(List<NamedQuery> namedQueries) {
         this.namedQueries = namedQueries;
     }

     // Getters and setters
}
 class NamedQuery {
    private String queryId;
    private List<String> selectedAttributes;

     public List<String> getSelectedAttributes() {
         return selectedAttributes;
     }

     public void setSelectedAttributes(List<String> selectedAttributes) {
         this.selectedAttributes = selectedAttributes;
     }

     public String getQueryId() {
         return queryId;
     }

     public void setQueryId(String queryId) {
         this.queryId = queryId;
     }
// Getters and setters
}
