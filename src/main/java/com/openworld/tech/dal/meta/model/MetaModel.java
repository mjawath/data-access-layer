package com.openworld.tech.dal.meta.model;

import lombok.*;

import java.util.Map;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetaModel {

    //<global/region/countryCode || DomainDetail>
    private Map<String, DomainObject> domainObjectMap;


}
