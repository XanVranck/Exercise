package be.cegeka.domain.certificaat;

import be.cegeka.controller.CertificaatDTO;

import javax.inject.Named;

@Named
public class CertificaatFactory {
    public CertificaatFactory(){}

    public Certificaat createCertificaat(CertificaatDTO certificaat) {
        return new Certificaat(certificaat.getCertifcaatNumber(), certificaat.getCertificaatDatum(), certificaat.getSpecifiekTonnage());
    }
}
