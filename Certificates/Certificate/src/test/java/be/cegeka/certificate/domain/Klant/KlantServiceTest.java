package be.cegeka.certificate.domain.Klant;

import be.cegeka.certificate.domain.klant.Adres;
import be.cegeka.certificate.domain.klant.Klant;
import be.cegeka.certificate.domain.klant.KlantRepository;
import be.cegeka.certificate.domain.klant.KlantService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;

/**
 * Created by xanv on 27/02/2017.
 */
public class KlantServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private KlantService klantService;

    @Mock
    private KlantRepository klantRepository;

    @Test
    public void addCustomer() throws Exception {
        Adres address1 = new Adres("Doelhaagstraat", "78", "5555", "Rumst");
        Klant klant=new Klant("paulien",address1);
        klantService.addKlant(klant);
        verify(klantRepository).addKlant(refEq(klant));
    }

}