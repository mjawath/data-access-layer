package com.openworld.tech.dal.meta;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
public  class DomainObject {
    private String region;
    private String countryCode;
    private String domainName;
    private String tableName;
    private TableDetail tableDetail;
    //map the attribute name with detail of attribute
    private Map<String, AttributeDetail> attributeDetailMap;


}