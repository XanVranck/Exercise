package be.cegeka.controller;

import be.cegeka.domain.klant.Klant;
import be.cegeka.domain.klant.KlantService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/klant")
@Transactional
public class KlantController {
    @Inject
    private KlantService klantService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void addKlant(@RequestBody Klant klant){
        klantService.addKlant(klant);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Klant> getKlanten(){
        return klantService.getKlanten();
    }


}
