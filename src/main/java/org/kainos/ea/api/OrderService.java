package org.kainos.ea.api;

import org.kainos.ea.cli.Order;
import org.kainos.ea.cli.OrderRequest;
import org.kainos.ea.cli.Product;
import org.kainos.ea.cli.ProductRequest;
import org.kainos.ea.client.*;
import org.kainos.ea.db.OrderDao;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class OrderService {
    private OrderDao orderDao = new OrderDao();

        public List<Order> getAllOrders() throws FailedToGetOrdersException {

            try {
                List<Order> orderList = orderDao.getAllOrders();
                return orderList;

            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
            throw new FailedToGetOrdersException();
        }
            // print out all orders
            //for (Order order : orderList)
            //  System.out.println(orderList);

            //print out by order date descending
            //  Comparator c =Collections.reverseOrder();
            //Collections.sort(orderList, c);
            //orderList.stream().forEach(System.out::println);


            //only show orders from last week
            //orderList.stream().filter(order -> order.getOrderDate().before(Date.from(Instant.now().minus(Duration.ofDays(7))))).forEach(System.out::println);


//        //show the most recent order
//        Comparator c =Collections.reverseOrder();
//        Collections.sort(orderList, c);
//        System.out.println(orderList.get(0));
//
//        // to get the older order
//        //show the most recent order (make sure previous lines of code has been run as this will sort ascening
//        Comparator c =Collections.reverseOrder();
//        Collections.sort(orderList, c);
//        System.out.println(orderList.get(0));

            //to get total number of orders - use list size

            //  System.out.println(orderList.size());

            //map allows you to associate a key with a value
            //map <type of key (will be unique eg customer id, type of value>

            //groups by customer ID and counts the amount of times that ID exists
            //then uses max and min from collections
            //set as long as counting function uses long

//       // Map<Integer, Long> countOrderMap = orderList.stream()
//                .collect(Collectors.groupingBy(Order::getCustomerId, Collectors.counting()));
//
//        System.out.println("Customer with most orders: "
//                + Collections.max(countOrderMap.entrySet(), Map.Entry.comparingByValue()).getKey());
//
//        System.out.println("Customer with least orders: "
//                + Collections.min(countOrderMap.entrySet(), Map.Entry.comparingByValue()).getKey());

            public Order getOrdersById(int id) throws FailedToGetOrdersException, OrderDoesNotExistException {
                try {
                    Order order = orderDao.getOrderById(id);
                    if (order == null) {
                        throw new OrderDoesNotExistException();
                    }
                    return order;
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                    throw new FailedToGetOrdersException();
                }
            }


    public int createOrder(OrderRequest order) throws FailedToCreateOrderException {
        try {

            //String validation = productValidator.isValidProduct(product);

            //  if (validation != null){
            //    throw new InvalidProductException(validation);
            // }

            int id = orderDao.createOrder(order);
            if (id == -1) {

                throw new FailedToCreateOrderException();

            }

            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToCreateOrderException();
        }

    }

    //should have invalid order exception from preious tasks - needs to update
    public void updateOrder(int id, OrderRequest order) throws OrderDoesNotExistException, FailedToUpdateOrderException {
        try {
            //havent created yet from previous task
            //   String validation = orderValidator.isValidProduct(order);

           // if (validation != null) {
              //  throw new InvalidProductException(validation);
           // }
            Order orderToUpdate = orderDao.getOrderById(id);

            if (orderToUpdate == null) {
                throw new OrderDoesNotExistException();
            }
            orderDao.updateOrder(id, order);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToUpdateOrderException();
        }
    }

    //Need Order does not exist valdation
    public void deleteOrder(int id) throws OrderDoesNotExistException, FailedToDeleteOrderException {

        try {
            Order orderToDelete = orderDao.getOrderById(id);

            if (orderToDelete == null) {
                throw new OrderDoesNotExistException();
            }

            orderDao.deleteOrder(id);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToDeleteOrderException();
        }

    }

    }

