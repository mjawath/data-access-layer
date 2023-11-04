package com.openworld.tech.dal.meta;

import com.openworld.tech.dal.meta.entity.Shipment;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class QueryTestBed {

    @Autowired
    private EntityManager entityManager;

    public void testShipmentWithSimple() {
        // node shipment , node has these attributes
        // node customer , node has these attributes
        List l = entityManager.createQuery("SELECT NEW Shipment(awbNumber) " +
                "FROM Shipment s ").getResultList();
//        System.out.println(l.get(0));
    }

    public void testShipmentWithCustomerAndCommodity() {
        // node shipment , node has these attributes
        // node customer , node has these attributes
//        " NEW Shipment(Shipment.selectedattributes) " +
//        " NEW Customer(Customer.selectedattributes) " +

        List l = entityManager.createQuery("SELECT s, c, co " +
                "FROM Shipment s " +
                "LEFT JOIN s.customer c ON s.id = c.shipmentId " +
                "LEFT JOIN s.commodities co ON s.id = co.shipmentId").getResultList();
//        System.out.println(l.get(0));
    }

    @Transactional
    public void testShipmentUpdate() {
//        EntityManagerFactory emf= Persistence.createEntityManagerFactory("GEMINI_2_0");
        Shipment shipment = new Shipment();
        shipment.setId(1l);
        shipment.setTotalValue(20231026d);
//        EntityManager entityManager = emf.createEntityManager();
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
        int records = entityManager.createQuery(
                        " UPDATE Shipment s SET s.totalWeight = :totalWeight WHERE s.id = :id")
                .setParameter("id", shipment.getId())
                .setParameter("totalWeight", shipment.getTotalValue())
                .executeUpdate();
//        transaction.commit();
        System.out.println(records + " updated ");
    }
}
