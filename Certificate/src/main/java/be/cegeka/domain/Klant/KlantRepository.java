package be.cegeka.domain.Klant;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by xanv on 27/02/2017.
 */
@Named
public class KlantRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void addKlant(Klant klant) {
        entityManager.persist(klant);
    }

    public List<Klant> getKlanten() {
        return entityManager.createQuery("select k from Klant k", Klant.class).getResultList();
    }
}