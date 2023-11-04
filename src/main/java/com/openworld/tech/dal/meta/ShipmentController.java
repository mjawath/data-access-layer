package com.openworld.tech.dal.meta;

import com.openworld.tech.dal.meta.entity.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {
    @Autowired
    private ShipmentService shipmentService;

    @GetMapping
    public List<Shipment> getShipments(){
        return shipmentService.getShipment("one");
    }
}
