package com.openworld.tech.dal.meta.queryconfig;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MetaDataService {

    @Autowired
    private QueryConfiguration queryConfiguration;//configuration

    @Autowired
    private GenericDao dao;

    public String getData(QueryOptions options) {
        if (options.getQueryId() != null) {
            //TODO- handle from cache ,add to cache , update cache, load to cache , refresh cache
            QueryDetail queryDetail = dao.findSingleByQuery(QueryDetail.class,
                    " SELECT c FROM QueryDetail c WHERE c.id = '" + options.getQueryId() + "' ");
            List<String> selectedAttributes = queryDetail.getSelectedAttributes();// id,awbNumber
            StringBuilder q=new StringBuilder(" SELECT ");
            q.append("  ");
            for(String att:selectedAttributes){
                q.append("");
            }


        }
//        return dao.find(Shipment.class, options.getId());
        return "";
    }


    @PostConstruct
    private void loadMappingConfig() {
//        dao.findByQuery(QueryDetail.class, " SELECT c FROM QueryDetail c ");
    }


}
