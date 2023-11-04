package com.openworld.tech.dal.meta.queryconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class GenericController {
    @Autowired
    private MetaDataService metaDataService;

    @GetMapping
    public String getData(@RequestHeader(required = false) MultiValueMap<String, String> headers){
        String country = headers.getFirst("country");
        String queryId = headers.getFirst("queryId");

        QueryOptions queryOptions = new QueryOptions();
        queryOptions.setCountry(headers.getFirst("country"));
        queryOptions.setQueryId(headers.getFirst("queryId"));
        queryOptions.setRootNode(headers.getFirst("rootNode"));
        queryOptions.setQuery(headers.getFirst("query"));

        return metaDataService.getData(queryOptions);
    }


}

