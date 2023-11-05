package com.openworld.tech.dal.meta;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ColumnDetail {
    private String column;
    private ColumnType columnType;
    private String columnDefault;
    private IDType idType;
    private TableDetail tableDetail;

    public enum IDType {
        PRIMARY_KEY,
        PARENT_KEY,
        ROOT_KEY,
    }

    public enum ColumnType {
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