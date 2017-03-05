package be.cegeka.domain.certificaat;

import be.cegeka.controller.CertificaatDTO;
import be.cegeka.domain.order.Order;
import be.cegeka.domain.order.OrderRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CertificaatService {
    @Inject
    private CertificaatRepository certificaatRepository;

    @Inject
    private OrderRepository orderRepository;

    @Inject
    private CertificaatFactory certificaatFactory;

    public List<Certificaat> getCertificates() {
        return certificaatRepository.getCertificats();
    }

    public void addCertificaat(CertificaatDTO certificaat){
        Order order= orderRepository.findOrder(certificaat.getOrderId());

        order.addCertificaat(certificaatFactory.createCertificaat(certificaat));
    }

}
