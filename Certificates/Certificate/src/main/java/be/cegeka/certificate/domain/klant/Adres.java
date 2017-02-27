package be.cegeka.certificate.domain.klant;

/**
 * Created by xanv on 27/02/2017.
 */
public class Adres {
    private String street;
    private String number;
    private String zipCode;
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
