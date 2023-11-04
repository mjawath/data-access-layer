package com.openworld.tech.dal.meta;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MetaApplicationTests {
//
//    @Autowired
//    private QueryBuilder buildQuery;

    @Test
    void contextLoads() {
        List<String> selectedAttributes = Arrays.asList("id", "location", "customer.id", "customer.name");
//		String query = buildQuery.buildQuery(selectedAttributes, "shipment-with-customer");
//		Assertions.assertEquals("SELECT id FROM shipment",query);
    }

}
