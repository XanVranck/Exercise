package be.cegeka.infrastructure;

import be.cegeka.CertificateApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CertificateApplication.class)
@Transactional
@ActiveProfiles("dev")
public class SpringIntegrationTest {
}
