package be.cegeka.certificate.domain.klant;

/**
 * Created by xanv on 27/02/2017.
 */
public class Klant {
    private String name;
    private Adres address;

    public Klant() {
    }

    public Klant(String name, Adres address) {
        this.name = name;
        this.address = address;
    }



    public String getName() {
        return name;
    }

    public Adres getAddress() {
        return address;
    }



}
