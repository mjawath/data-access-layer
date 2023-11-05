package com.openworld.tech.dal.meta;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
public class TableDetail {
    private String region;
    private String countryCode;
    private String domainName;
    private String tableName;
    private Map<String,ColumnDetail> columnDetailMap;
}
