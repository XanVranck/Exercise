package be.cegeka.domain.Klant;

import be.cegeka.domain.klant.Klant;
import be.cegeka.domain.klant.KlantRepository;
import be.cegeka.domain.klant.KlantService;
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
        Klant klant=new Klant("paulien","Doelhaagstraat", "78", "5555", "Rumst");
        klantService.addKlant(klant);
        verify(klantRepository).addKlant(refEq(klant));
    }

}