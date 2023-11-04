package com.openworld.tech.dal.meta.queryconfig;

import org.springframework.beans.factory.annotation.Autowired;

public class QueryBuild {

    @Autowired
    private QueryConfiguration queryConfiguration;

    public String getQuery(QueryDetail queryDetail){

        return "";//queryConfiguration.getQuery(countryCode,queryId);
    }

}
