package org.kainos.ea.core;

import org.kainos.ea.cli.Customer;
import org.kainos.ea.cli.OrderRequest;
import org.kainos.ea.db.CustomerDao;

import java.sql.Date;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;

public class OrderValidator {

    private CustomerDao customerDao = new CustomerDao();

    public String isValidOrder(OrderRequest order) throws SQLException {
        Customer customer = customerDao.getCustomerById(order.getCustomerID());

        if (customer == null) {
            return "Customer ID does not exist";
        }
        if (order.getOrderDate().before(Date.from(Instant.now().minus(Duration.ofDays(365))))) {

        }
        return null;
    }
}