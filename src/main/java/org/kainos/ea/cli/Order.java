package org.kainos.ea.cli;
import java.util.Date;


public class Order implements Comparable<Order> {

    private int orderId;
    private int customerId;

    public Order(int orderId, int customerId, Date orderDate) {
        setOrderId(orderId);
        setCustomerId(customerId);
        setOrderDate(orderDate);

    }

    private Date orderDate;


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
           this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }


    //@Override
    //public int compareTo(Order order) {
    //     return this.getOrderId().compareTo(order.getOrderId());

    // }


//}


    //comparing order dates
//overriding the default which would compare the references
    //comparing date within current class to date within object ( eg order object)
    @Override
    public int compareTo(Order order) {
        return this.getOrderDate().compareTo(order.getOrderDate());
    }
   @Override
   public String toString() {
      return "Order{" +
            "orderId=" + orderId +
            ", customerId=" + customerId +
             ", orderDate=" + orderDate +
             '}';
  }


    }
