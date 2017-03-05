package be.cegeka.domain.order;

import be.cegeka.controller.OrderDTO;
import be.cegeka.domain.klant.Klant;
import be.cegeka.domain.klant.KlantRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by xanv on 28/02/2017.
 */
@Named
public class OrderService {

    @Inject
    private OrderFactory orderFactory;

    @Inject
    private KlantRepository klantRepository;

    @Inject
    private OrderRepository orderRepository;

    public void addOrder(OrderDTO order){
        Klant klant = klantRepository.findKlant(order.getKlantId());

        klant.addOrder(orderFactory.createOrder(order));
    }

    public List<Order> getOrders(){
        return orderRepository.getOrders();
    }

}
