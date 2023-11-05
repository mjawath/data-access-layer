package com.openworld.tech.dal.meta;

import lombok.*;

import java.util.Map;

@NoArgsConstructor
@Setter
@Getter
//@Builder
public class MetaModel {

    //<global/region/countryCode || DomainDetail>
    private Map<String, DomainObject> domainObjectMap;

    public static class DomainObject {
        private String region;
        private String countryCode;
        private String domainName;
        private String tableName;
        //map the attribute name with detail of attribute
        private Map<String,AttributeDetail> attributeDetailMap;


    }
    public static class AttributeDetail{
        private String attributeName;
        private AttributeType attributeType;//enum

        public enum AttributeType{
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
    public static class TableColumnDetail{
        private String column;
        private ColumnType columnType;
        private String columnDefault;
        private IDType idType;

        public enum IDType{
            PRIMARY_KEY,
            PARENT_KEY,
            ROOT_KEY,
        }
        public enum ColumnType{
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
}

