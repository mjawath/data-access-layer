package com.openworld.tech.dal.meta;

import com.openworld.tech.dal.meta.model.DomainObject;
import com.openworld.tech.dal.meta.model.MetaModel;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class QueryValidator {

    public boolean isValidQuery(MetaModel metaModel, String rootNode, String ...selectedFields) {
        DomainObject domainObject = metaModel.getDomainObject(rootNode);
        //check if the attribute exists
        if (domainObject == null) {
//             "Root object is not found";
            return false;
        }
        return true;
    }
}
