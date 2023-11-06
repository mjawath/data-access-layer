package com.openworld.tech.dal.meta;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder
@ToString(exclude = "attributeDetailMap")
public class DomainObject {
    private String region;
    private String countryCode;
    private String domainName;
    private String tableName;
    private TableDetail tableDetail;
    //map the attribute name with detail of attribute
    private Map<String, AttributeDetail> attributeDetailMap;

    //set the column detail
    public void setAttributeDetailMap(Map<String, AttributeDetail> attributeDetailMap) {
        this.attributeDetailMap = attributeDetailMap;
        this.attributeDetailMap.forEach((k,v) -> v.setDomainObject(this));
    }
}