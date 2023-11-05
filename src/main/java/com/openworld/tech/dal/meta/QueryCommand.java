package com.openworld.tech.dal.meta;

import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;

import java.util.Map;

//query --rootObject shipment --values 1,2,3
@Command
public class QueryCommand {

    private MetaModel metaModel;

    public QueryCommand() {
        init();
    }


    @Command(command = "query")
    public String query(@Option(defaultValue = "shipment") String rootObject, String... values) {
        System.out.println("test" + rootObject);
        return rootObject + values;
    }

    public void init() {
        metaModel = new MetaModel();
        DomainObject shipmentObj = DomainObject.builder()
                .domainName("shipment")
                .build();
        AttributeDetail id = AttributeDetail.builder()
                .attributeName("id")
                .attributeType(AttributeDetail.AttributeType.LONG)
                .build();
        AttributeDetail awbNumber = AttributeDetail.builder()
                .attributeName("awbNumber")
                .attributeType(AttributeDetail.AttributeType.STRING)
                .build();

        shipmentObj.setAttributeDetailMap(Map.of("id", id,
                "awbNumber", awbNumber));

        metaModel.setDomainObjectMap(Map.of(shipmentObj.getDomainName(), shipmentObj));
    }
}

