package be.cegeka.domain.order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by xanv on 28/02/2017.
 */
public class OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;


    public void addOrder(Order order) {
        entityManager.persist(order);
    }

    public List<Order> getOrders() {
        return entityManager.createQuery("select o from Order o", Order.class).getResultList();
    }
}
