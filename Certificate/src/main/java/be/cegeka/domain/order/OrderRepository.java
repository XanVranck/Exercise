package be.cegeka.domain.order;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by xanv on 28/02/2017.
 */
@Named
public class OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;


    public void addOrder(Order order) {
        entityManager.persist(order);
    }

    public List<Order> getOrders() {
        return entityManager.createQuery("select o from Order o", Order.class).getResultList();
    }

    public Order findOrder(int orderId) {
        return entityManager.find(Order.class, orderId);
    }

}
