package be.cegeka.certificate.domain.klant;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by xanv on 27/02/2017.
 */
public class Adres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADRES_ID")
    private int id;
    @Column(name = "STRAAT")
    private String street;
    @Column(name = "NUMMER")
    private String number;
    @Column(name = "POSTCODE")
    private String zipCode;
    @Column(name = "STAD")
    private String city;

    public Adres() {
    }

    public Adres(String street, String number, String zipCode, String city) {
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }
}
