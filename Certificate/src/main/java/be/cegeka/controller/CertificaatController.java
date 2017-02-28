package be.cegeka.controller;

import be.cegeka.domain.certificaat.Certificaat;
import be.cegeka.domain.certificaat.CertificaatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/certificaat")
public class CertificaatController {
    @Inject
    private CertificaatService certificaatService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void addCertificaat(@RequestBody Certificaat certificaat){
        certificaatService.addCertificate(certificaat);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Certificaat> getCertificaten(){
        return certificaatService.getCertificates();
    }


}
