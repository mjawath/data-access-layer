package com.openworld.tech.dal.meta.queryconfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Map;

@Component
public class QueryConfiguration {

    private MetaModel metaModel;
    private Map<String, QueryDetail> queryDetailMap;
    @Autowired
    private GenericDao dao;

    public QueryConfiguration() {
        loadMappingConfig();
    }

    public String getQuery(String countryCode, String queryId) {

        metaModel.getDomainObjects()
                .stream()
                .filter(domainObject -> domainObject.getNamedQueries().equals(countryCode));
        return "";
    }

    @PostConstruct
    private void loadMappingConfig() {
//        dao.findByQuery(QueryDetail.class, UUID.randomUUID().toString());
    }

    private void loadMappingConfigxx() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Queries.json");
            metaModel = objectMapper.readValue(inputStream, MetaModel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



