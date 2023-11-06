package com.openworld.tech.dal.meta;

import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;

import java.util.Arrays;
import java.util.Map;

//query --rootObject shipment --values id,awbNumber
@Command
public class QueryCommand {

    private MetaModel metaModel;

    public QueryCommand() {
        init();
    }


    @Command(command = "query")
    public String query(@Option(defaultValue = "shipment") String rootObject, String... values) {
        System.out.println("Query Command Executed ");
        System.out.println("Root object context: " + rootObject);
        System.out.println("Attributes to query: " + Arrays.toString(values));

        if (!metaModel.getDomainObjectMap().containsKey(rootObject)) {
            return "Root object is not found";
        }
        //get the domain object from the map
        DomainObject domainObject = metaModel.getDomainObjectMap().get(rootObject);

        //print the attribute detail of getAttributeDetailMap
        for (Map.Entry<String, AttributeDetail> entry : domainObject.getAttributeDetailMap().entrySet()) {

            System.out.println("AttributeDetail Detail: "+entry.getValue());
        }

        //get the table detail from the domain object
        TableDetail tableDetail = domainObject.getTableDetail();
        //check if the attribute exists
        if (tableDetail==null) {
            return "TableDetail is not found";
        }
        System.out.println(tableDetail);

        //print the attribute detail of tableDetail
        for (Map.Entry<String, ColumnDetail> entry : domainObject.getTableDetail().getColumnDetailMap().entrySet()) {
            System.out.println("Table Column Detail: "+entry.getValue());
        }
        //for passed values find the attributes from attribute map
        
        //check if the attribute exists
//        if (!entry) {
//            return "Attribute is not found";
//        }


        return "query command executed";
    }

    public void init() {
        metaModel = new MetaModel();


        ColumnDetail colId = ColumnDetail.builder()
                .column("ID")
                .columnType(ColumnDetail.ColumnType.LONG)
                .idType(ColumnDetail.IDType.PRIMARY_KEY)
                .build();
        ColumnDetail colAwbNumber = ColumnDetail.builder()
                .column("AWB_Number")
                .columnType(ColumnDetail.ColumnType.STRING)
                .build();

        TableDetail tableDetail = TableDetail.builder()
                .tableName("SHIPMENT")
                .build();
        tableDetail.setColumnDetailMap(Map.of(colId.getColumn(), colId,
                colAwbNumber.getColumn(), colAwbNumber));


        AttributeDetail id = AttributeDetail.builder()
                .attributeName("id")
                .attributeType(AttributeDetail.AttributeType.LONG)
                .columnDetail(colId)
                .build();

        AttributeDetail awbNumber = AttributeDetail.builder()
                .attributeName("awbNumber")
                .attributeType(AttributeDetail.AttributeType.STRING)
                .columnDetail(colAwbNumber)
                .build();

        DomainObject shipmentObj = DomainObject.builder()
                .domainName("shipment")
                .tableDetail(tableDetail)
                .build();
        shipmentObj.setAttributeDetailMap(Map.of(id.getAttributeName(), id,
                awbNumber.getAttributeName(), awbNumber));

        metaModel.setDomainObjectMap(Map.of(shipmentObj.getDomainName(), shipmentObj));
    }
}

