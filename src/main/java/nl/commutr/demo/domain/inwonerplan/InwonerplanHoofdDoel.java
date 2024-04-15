package nl.commutr.demo.domain.inwonerplan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import nl.commutr.demo.domain.aanbod.Subdoel;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class InwonerplanHoofdDoel {
    public LocalDate begindatum;
    public String naamDoel;
    @ManyToOne
    public Subdoel doel;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    public LocalDate getBegindatum() {
        return begindatum;
    }

    public void setBegindatum(LocalDate begindatum) {
        this.begindatum = begindatum;
    }

    public String getNaamDoel() {
        return naamDoel;
    }

    public void setNaamDoel(String naamDoel) {
        this.naamDoel = naamDoel;
    }

    public Subdoel getDoel() {
        return doel;
    }

    public void setDoel(Subdoel doel) {
        this.doel = doel;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public InwonerplanHoofdDoel(Subdoel hoofddoel) {
        this.begindatum = LocalDate.now();
        this.doel = hoofddoel;
        this.naamDoel = hoofddoel.getNaam();
    }

    public InwonerplanHoofdDoel() {
    }
}
