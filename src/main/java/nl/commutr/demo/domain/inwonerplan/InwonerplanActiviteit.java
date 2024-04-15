package nl.commutr.demo.domain.inwonerplan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import nl.commutr.demo.domain.aanbod.Actiehouder;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class InwonerplanActiviteit {
    @ManyToOne
    Actiehouder actiehouder;

    LocalDate begindatum;

    LocalDate einddatum;

    String naam;

    String omschrijving;
    @Id
    @GeneratedValue
    private UUID id;

    public InwonerplanActiviteit() {
    }

    public Actiehouder getActiehouder() {
        return actiehouder;
    }

    public void setActiehouder(Actiehouder actiehouder) {
        this.actiehouder = actiehouder;
    }

    public LocalDate getBegindatum() {
        return begindatum;
    }

    public void setBegindatum(LocalDate begindatum) {
        this.begindatum = begindatum;
    }

    public LocalDate getEinddatum() {
        return einddatum;
    }

    public void setEinddatum(LocalDate einddatum) {
        this.einddatum = einddatum;
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

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
