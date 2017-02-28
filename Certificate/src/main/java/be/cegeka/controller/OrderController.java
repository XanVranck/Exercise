package be.cegeka.controller;

import be.cegeka.domain.order.Order;
import be.cegeka.domain.order.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Inject
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void addOrder(@RequestBody Order order){
        orderService.addOrder(order);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Order> getOrders(){
        return orderService.getOrders();
    }
}
