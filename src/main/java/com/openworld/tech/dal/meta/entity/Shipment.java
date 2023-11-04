package com.openworld.tech.dal.meta.entity;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Shipment implements Serializable {
    private Long id;
    private String awbNumber;
    private Double totalWeight;
    private Double totalValue;
    private Customer customer;
    private LocalDate committedDate;
    private LocalDateTime updatedDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAwbNumber() {
        return awbNumber;
    }

    public void setAwbNumber(String awbNumber) {
        this.awbNumber = awbNumber;
    }

    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getCommittedDate() {
        return committedDate;
    }

    public void setCommittedDate(LocalDate committedDate) {
        this.committedDate = committedDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    // Getters and setters
}
