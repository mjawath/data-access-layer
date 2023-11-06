package com.openworld.tech.dal.meta;

import com.openworld.tech.dal.meta.model.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ExcelToMetaModelMapper {

    public MetaModel mapExcelToMetaModel() {
        Resource resource = new ClassPathResource("metamodel.xlsx");

        MetaModel metaModel = new MetaModel();

        try (Workbook workbook = new XSSFWorkbook(resource.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet

            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);

                String global =valueAt(row,0);
                String region =valueAt(row,1);
                String countryCode = valueAt(row,2);
                String domainName =  valueAt(row,3);
                String tableName = valueAt(row,8);
                // Create a new DomainObject
                DomainObject domainObject = DomainObject.builder()
                        .region(region)
                        .countryCode(countryCode)
                        .domainName(domainName)
                        .tableName(tableName).build();


                // Create a new TableDetail
                TableDetail tableDetail = TableDetail.builder()
                        .region(region)
                        .countryCode(countryCode)
                        .domainName(domainName)
                        .tableName(tableName).build();

                // Create a new ColumnDetail
                String columnName = valueAt(row,9);
                Map< String, ColumnDetail> columnDetailMap = new HashMap<>();
                if(columnName != null) {
                    ColumnDetail columnDetail = ColumnDetail.builder()
                            .column(columnName)
                            .build();
                    columnDetailMap.put(columnName, columnDetail);
                }

                // Set other column properties as needed
                String columnType = valueAt(row,10);
                if(columnType != null) {
                    ColumnDetail columnDetail = ColumnDetail.builder()
                            .column(columnType)
                            .build();
                    columnDetailMap.put(columnType, columnDetail);
                }

                String columnDefault = valueAt(row,11);
                if(columnDefault != null) {
                    ColumnDetail columnDetail = ColumnDetail.builder()
                            .column(columnDefault)
                            .build();
                    columnDetailMap.put(columnDefault, columnDetail);
                }
                // Add the ColumnDetail to the TableDetail
                tableDetail.setColumnDetailMap(columnDetailMap);

                // Add the TableDetail to the DomainObject
                domainObject.setTableDetail(tableDetail);

                String attributeName = valueAt(row, 6);
                String attributeType = valueAt(row, 7);
                AttributeDetail attributeDetail = AttributeDetail.builder()
                        .attributeName(attributeName)
                        .attributeType(AttributeDetail.AttributeType.valueOf(attributeType))
                        .build();

                domainObject.setAttributeDetailMap(Map.of(attributeName, attributeDetail));
                // Add the DomainObject to the MetaModel
                metaModel.addDomainObject(domainObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return metaModel;
    }
    private String valueAt(Row row,int index) {
        Cell cell = row.getCell(index);
        return cell == null ? null : cell.getStringCellValue();
    }
}
