package com.openworld.tech.dal.meta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MetaApplication implements CommandLineRunner {


    @Autowired
    private QueryTestBed queryTestBed;

    public static void main(String[] args) {

        SpringApplication.run(MetaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        queryTestBed.testShipmentWithSimple();
//        queryTestBed.testShipmentWithCustomerAndCommodity();
//        queryTestBed. testShipmentUpdate();
//        queryTestBed. testShipmentUpdate();
    }
}
