package com.openworld.tech.dal.meta;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder
@ToString(exclude = "columnDetailMap")
public class TableDetail {
    private String region;
    private String countryCode;
    private String domainName;
    private String tableName;
    private Map<String,ColumnDetail> columnDetailMap;

    //set the column detail
    public void setColumnDetailMap(Map<String, ColumnDetail> columnDetailMap) {
        this.columnDetailMap = columnDetailMap;
        this.columnDetailMap.forEach((k,v) -> v.setTableDetail(this));
    }
}
