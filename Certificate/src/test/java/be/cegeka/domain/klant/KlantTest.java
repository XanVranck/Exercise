package be.cegeka.domain.klant;

import be.cegeka.domain.order.Order;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class KlantTest {

    @Test
    public void addOrder() throws Exception {
        Klant klant = new Klant();
        Order order = new Order();

        klant.addOrder(order);

        assertThat(klant.getOrders()).containsOnly(order);
    }

}