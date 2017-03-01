package be.cegeka.domain.certificaat;

import be.cegeka.CertificateApplication;
import org.assertj.core.api.Assertions;
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
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CertificateApplication.class)
@Transactional
public class CertificaatRepositoryTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private CertificaatRepository certificaatRepository;

    private Certificaat one, two;

    @Before
    public void setup() {
        one = new Certificaat("1", "1",50);
        two = new Certificaat("3", "1", 79);
        entityManager.persist(one);
        entityManager.persist(two);
    }

    @Test
    public void addCertificaat() throws Exception {
        Certificaat certificaat = new Certificaat("2", "1", 6541);
        certificaatRepository.addCertificate(certificaat);
        Assertions.assertThat(certificaatRepository.getCertificats()).contains(one, two, certificaat);
    }

    @Test
    public void getKlanten() throws Exception {
        Assertions.assertThat(certificaatRepository.getCertificats()).contains(one, two);
    }

    @After
    public void cleanDatabase() {
        entityManager.clear();
    }

}