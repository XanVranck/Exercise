package be.cegeka.domain.certificaat;

import be.cegeka.domain.order.Order;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by xanv on 28/02/2017.
 */
public class CertificaatService {
    @Inject
    CertificaatRepository certificaatRepository;

    public void addCertificate(Certificaat certificaat) {
        certificaatRepository.addCertificate(certificaat);
    }

    public List<Certificaat> getCertificates() {
        return certificaatRepository.getCertificats();
    }

}
