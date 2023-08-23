package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class OrderRequest {
    private int customerId;
    private Date orderDate;

    @JsonCreator
    public OrderRequest(
            @JsonProperty("customerID") int customerId,
            @JsonProperty("orderDate") Date orderDate) {
        this.customerId = customerId;
        this.orderDate = orderDate;
    }

    public int getCustomerID() {
        return customerId;
    }

    public void setCustomerID(int customerID) {
        this.customerId = customerID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
