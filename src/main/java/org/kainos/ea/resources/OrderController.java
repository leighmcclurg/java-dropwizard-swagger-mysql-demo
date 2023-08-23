package org.kainos.ea.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import org.kainos.ea.api.OrderService;
import org.kainos.ea.cli.Order;
import org.kainos.ea.cli.OrderRequest;
import org.kainos.ea.cli.ProductRequest;
import org.kainos.ea.client.*;

import java.util.List;
@Api("Engineering Academy Dropwizard Product API")
@Path("/api")
public class OrderController {
    private OrderService orderService = new OrderService();

    @GET
    @Path("/orders")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrders() {

        //List<Order> getOrders(){
        try {
            return Response.ok(orderService.getAllOrders()).build();
        } catch (
                FailedToGetOrdersException e) {
            System.err.println(e.getMessage());


            return Response.serverError().build();
        }
    }

    @GET
    @Path("/orders/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrdersById(@PathParam("id") int id) {

        try {
            return Response.ok(orderService.getOrdersById(id)).build();
        } catch (FailedToGetOrdersException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        } catch (OrderDoesNotExistException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @POST
    @Path("/orders")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOrder(OrderRequest order) {
        try {
            return Response.ok(orderService.createOrder(order)).build();
        } catch (FailedToCreateOrderException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
            //  } catch (InvalidProductException e) {
            //      System.err.println(e.getMessage());

            //    return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }


    @PUT
    @Path("/orders{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateOrder(@PathParam("id") int id, OrderRequest order) {

        try {
            orderService.updateOrder(id, order);
            return Response.ok().build();
        }catch  (OrderDoesNotExistException e){
          System.err.println(e.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (FailedToUpdateOrderException  e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        }
    }


    @DELETE
    @Path("/order{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteOrder(@PathParam("id") int id) {

        try {
            orderService.deleteOrder(id);

            return Response.ok().build();
        } catch (OrderDoesNotExistException e) {

            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (FailedToDeleteOrderException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        }
    }
}
