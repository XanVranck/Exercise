package be.cegeka.domain.order;

import be.cegeka.domain.certificaat.Certificaat;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xanv on 5/03/2017.
 */
public class OrderTest {
    @Test
    public void addCertificaat() throws Exception {
        Order order = new Order();
        Certificaat certificaat = new Certificaat();

        order.addCertificaat(certificaat);

        Assertions.assertThat(order.getCertificaten()).containsOnly(certificaat);
    }
}