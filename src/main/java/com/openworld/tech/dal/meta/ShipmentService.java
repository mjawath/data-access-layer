package com.openworld.tech.dal.meta;

import com.openworld.tech.dal.meta.entity.Shipment;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShipmentService {

    @Autowired
    private EntityManager entityManager;

    public List<Shipment> getShipment(String id) {
//        EntityManagerFactory emf= Persistence.createEntityManagerFactory("GEMINI_2_0");
//        EntityManager entityManager = emf.createEntityManager();

        //list of attributes to jpql
        List<Shipment> l =entityManager.createQuery("SELECT s, c, co " +
                "FROM Shipment s " +
                "LEFT JOIN Customer c ON s.id = c.shipmentId " +
                "LEFT JOIN Commodity co ON s.id = co.shipmentId").getResultList();
//         entityManager.createQuery("select s from Shipment s join Customer c on  ").getResultList();
        System.out.println(l.size());
        return l;// convert map to object
    }
}
