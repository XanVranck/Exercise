package be.cegeka.domain.order;

import be.cegeka.CertificateApplication;
import be.cegeka.infrastructure.SpringIntegrationTest;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by xanv on 28/02/2017.
 */

public class OrderRepositoryTest extends SpringIntegrationTest{
    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private OrderRepository orderRepository;

    private Order xan, nena, boe;

    @Before
    public void setup() {
        xan = new Order("1", "1", "iets", 2);
        nena = new Order("2", "3", "niks", 4);
        boe = new Order("4", "1", "waf", 4);
        entityManager.persist(xan);
        entityManager.persist(nena);
    }

    @Test
    public void getOrders() throws Exception {
        assertThat(orderRepository.getOrders()).contains(xan, nena);

    }

    @Test
    public void addOrders() throws Exception {
        orderRepository.addOrder(boe);
        assertThat(orderRepository.getOrders()).contains(xan, nena, boe);
    }

    @Test
    public void findOrder_OneResult(){
        Order actual = orderRepository.findOrder(xan.getOrderID());

        assertThat(actual).isEqualToComparingFieldByField(xan);
    }

    @Test
    public void findOrder_NoResult(){
        Order actual = orderRepository.findOrder(254445);

        assertThat(actual).isNull();
    }

    @After
    public void cleanDatabase() {
        entityManager.clear();
    }

}