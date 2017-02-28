package be.cegeka.domain.klant;

import java.util.List;

/**
 * Created by xanv on 27/02/2017.
 */
public class KlantService {
    private KlantRepository klantRepository;

    public void addKlant(Klant klant){
        klantRepository.addKlant(klant);
    }

    public List<Klant> getKlanten(){
        return klantRepository.getKlanten();
    }
}
