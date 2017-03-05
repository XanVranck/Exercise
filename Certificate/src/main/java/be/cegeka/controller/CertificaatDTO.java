package be.cegeka.controller;

/**
 * Created by xanv on 5/03/2017.
 */
public class CertificaatDTO {
    private String certifcaatNumber;
    private String certificaatDatum;
    private int specifiekTonnage;
    private int orderId;

    public CertificaatDTO(String certifcaatNumber, String certificaatDatum, int specifiekTonnage, int orderId) {
        this.certifcaatNumber = certifcaatNumber;
        this.certificaatDatum = certificaatDatum;
        this.specifiekTonnage = specifiekTonnage;
        this.orderId = orderId;
    }

    public String getCertifcaatNumber() {
        return certifcaatNumber;
    }

    public void setCertifcaatNumber(String certifcaatNumber) {
        this.certifcaatNumber = certifcaatNumber;
    }

    public String getCertificaatDatum() {
        return certificaatDatum;
    }

    public void setCertificaatDatum(String certificaatDatum) {
        this.certificaatDatum = certificaatDatum;
    }

    public int getSpecifiekTonnage() {
        return specifiekTonnage;
    }

    public void setSpecifiekTonnage(int specifiekTonnage) {
        this.specifiekTonnage = specifiekTonnage;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
