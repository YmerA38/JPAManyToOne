package stinus.com.jpamanytoone.model;

import jakarta.persistence.*;

@Entity
public class Kommune {
    String navn;
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 4)
    String kode;
    String href;
    @ManyToOne
    @JoinColumn(name="region",referencedColumnName = "kode")
    Region region;

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
