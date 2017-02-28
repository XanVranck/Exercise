package be.cegeka.domain.Klant;

import be.cegeka.CertificatesSpringBootApplication;
import be.cegeka.domain.klant.Klant;
import be.cegeka.domain.klant.KlantRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CertificatesSpringBootApplication.class)
@Transactional
public class KlantRepositoryTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private KlantRepository klantRepository;
    private Klant xan, nena;

    @Before
    public void setup() {
        xan = new Klant("Xan", "schoolstraat", "78", "1745", "Opwijk");
        nena = new Klant("Nena", "schoolstraat", "79", "1745", "Opwijk");
        entityManager.persist(xan);
        entityManager.persist(nena);
    }

    @Test
    public void addKlant() throws Exception {
        Klant moeke = new Klant("Moeke", "fl", "7", "11110", "qsd");
        klantRepository.addKlant(moeke);
        assertThat(klantRepository.getKlanten()).contains(xan, nena, moeke);
    }

    @Test
    public void getKlanten() throws Exception {
        assertThat(klantRepository.getKlanten()).contains(xan, nena);
    }

    @After
    public void cleanDatabase() {
        entityManager.clear();
    }

}