package be.cegeka.domain.certificaat;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "CERTIFICAAT_NUMBER")
    private String certificateNumber;

    @Column(name = "CERTIFICAAT_DATUM")
    private Date certificateDate;

    @Column(name = "SPECIFIEK_TONNAGE")
    private int specificWeight;

    public Certificaat() {
    }

    public Certificaat(String certificateNumber, Date certificateDate, int specificWeight) {
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

    public Date getCertificateDate() {
        return certificateDate;
    }

    public int getSpecificWeight() {
        return specificWeight;
    }
}
