package be.cegeka.domain.order;

import be.cegeka.controller.OrderDTO;

public class OrderFactory {
    public OrderFactory() {
    }

    Order createOrder(OrderDTO order) {
        return new Order(order.getWorkOrderNumber(), order.getPurchaseOrderNumber(), order.getSpecification(), order.getTotal());
    }
}