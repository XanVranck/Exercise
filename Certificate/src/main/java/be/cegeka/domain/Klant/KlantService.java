package be.cegeka.domain.klant;

import be.cegeka.domain.Klant.Klant;
import be.cegeka.domain.Klant.KlantRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by xanv on 27/02/2017.
 */
@Named
public class KlantService {
    @Inject
    private KlantRepository klantRepository;

    public void addKlant(Klant klant){
        klantRepository.addKlant(klant);
    }

    public List<Klant> getKlanten(){
        return klantRepository.getKlanten();
    }
}
