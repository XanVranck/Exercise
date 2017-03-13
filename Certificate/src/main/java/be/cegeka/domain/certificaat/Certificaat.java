package be.cegeka.domain.certificaat;

import javax.persistence.*;

/**
 * Created by xanv on 28/02/2017.
 */
@Entity
@Table(name = "CERTIFICATEN")
public class Certificaat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CERTIFICAAT_ID")
    private int certificaatID;

    @Column(name = "CERTIFICAAT_NUMBER", unique = true)
    private String certificateNumber;

    @Column(name = "CERTIFICAAT_DATUM")
    private String certificateDate;

    @Column(name = "SPECIFIEK_TONNAGE")
    private int specificWeight;

    public Certificaat() {
    }

    public Certificaat(String certificateNumber, String certificateDate, int specificWeight) {
        this.certificateNumber = certificateNumber;
        this.certificateDate = certificateDate;
        this.specificWeight = specificWeight;
    }

    public int getCertificaatID() {
        return certificaatID;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public String getCertificateDate() {
        return certificateDate;
    }

    public int getSpecificWeight() {
        return specificWeight;
    }
}
