package com.openworld.tech.dal.meta.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class AttributeDetail {
    private String attributeName;
    private AttributeType attributeType;//enum
    private ColumnDetail columnDetail;
    private DomainObject domainObject;

    public enum AttributeType {
        STRING,
        LONG,
        DOUBLE,
        BOOLEAN,
        Y_OR_N,// YES or NO
        OBJECT,
        LIST_VALUES,// list of defined string values
        LIST,
        MAP,
    }

}