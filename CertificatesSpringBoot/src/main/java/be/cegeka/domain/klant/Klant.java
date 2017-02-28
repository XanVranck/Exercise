package be.cegeka.domain.klant;

import be.cegeka.domain.certificaat.Certificaat;
import be.cegeka.domain.order.Order;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "KLANTEN")
public class Klant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KLANTEN_ID")
    private int klantenID;

    @Column(name = "NAAM")
    private String name;
    @Column(name = "STRAAT")
    private String street;
    @Column(name = "NUMMER")
    private String number;
    @Column(name = "POSTCODE")
    private String zipCode;
    @Column(name = "STAD")
    private String city;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Order> orders;


    public Klant(String name, String street, String number, String zipCode, String city) {
        this.name = name;
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.city = city;
    }

    public Klant() {
    }


    public String getName() {
        return name;
    }

    public int getKlantenID() {
        return klantenID;
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
