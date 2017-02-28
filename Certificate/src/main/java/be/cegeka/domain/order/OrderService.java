package be.cegeka.domain.order;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by xanv on 28/02/2017.
 */
@Named
public class OrderService {
    @Inject
    OrderRepository orderRepository;

    public void addOrder(Order order){
        orderRepository.addOrder(order);
    }

    public List<Order> getOrders(){
        return orderRepository.getOrders();
    }

}
