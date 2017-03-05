package be.cegeka.domain.certificaat;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Matchers.refEq;
import static org.mockito.Mockito.verify;

/**
 * Created by xanv on 28/02/2017.
 */
public class CertificaatServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private CertificaatService certificaatService;

    @Mock
    private CertificaatRepository certificaatRepository;

    @Test
    public void addCustomer() throws Exception {
        Certificaat certificaat=new Certificaat("50", "1",50000);
        certificaatService.addCertificate(certificaat);
        verify(certificaatRepository).addCertificate(refEq(certificaat));
    }


    @Test
    public void getCustomers() throws Exception{
        certificaatService.getCertificates();
        verify(certificaatRepository).getCertificats();
    }
}