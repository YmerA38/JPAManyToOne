package stinus.com.jpamanytoone.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import stinus.com.jpamanytoone.model.Kommune;

@Entity
public class Region {
    @Id
    private String kode;
    private String navn;
    private String href;
    @OneToMany
    @JsonBackReference
    private Set<Kommune> kommuner = new HashSet<>();

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Set<Kommune> getKommune() {
        return kommuner;
    }

    public void setKommune(Set<Kommune> kommuner) {
        this.kommuner = kommuner;
    }
}
