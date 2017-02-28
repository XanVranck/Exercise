package be.cegeka.domain.klant;

import javax.persistence.*;

@Entity
@Table(name = "klanten")
public class Klant {
    @Id
    @Column(name = "KLANTEN_ID")
    private int klantenID;
    @Column(name = "NAAM")
    private String name;
    @ManyToOne
    @JoinColumn(name = "ADRES_ID")
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
