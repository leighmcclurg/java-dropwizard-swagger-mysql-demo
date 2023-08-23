package org.kainos.ea.db;

import org.kainos.ea.cli.Customer;
import org.kainos.ea.cli.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDao {
    // get a list of customer IDs based on an ID
    private DatabaseConnector databaseConnector = new DatabaseConnector();


    public Customer getCustomerById(int id) throws SQLException {
        Connection c =databaseConnector.getConnection();

        Statement st = c .createStatement();

        ResultSet rs = st.executeQuery("SELECT `Customer`ID, Name, Address, Phone FROM Customer WHERE CustomerID=" +id +";") ;
        while (rs.next()) {
            Customer customer = new Customer(
                    rs.getInt("CustomerID"),
                    rs.getString("Name"),
                    rs.getString("Address"),
                    rs.getString("Phone")
            );
            return customer;
        }
        return null;

    }
}
