package nl.commutr.demo.domain.aanbod;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Ontwikkelwens {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    UUID id;
    String code;
    String naam;
    String omschrijving;
    boolean actief;


    public Ontwikkelwens(String code, String naam, String omschrijving, boolean actief) {
        this.code = code;
        this.naam = naam;
        this.omschrijving = omschrijving;
        this.actief = actief;
    }

    public Ontwikkelwens() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public boolean isActief() {
        return actief;
    }

    public void setActief(boolean actief) {
        this.actief = actief;
    }
}
