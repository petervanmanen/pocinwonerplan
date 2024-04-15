package nl.commutr.demo.domain.aanbod;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;
import java.util.UUID;

@Entity
public class Aandachtspunt {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    UUID id;
    String code;
    String naamAandachtsPunt;
    String omschrijving;
    boolean actief;


    public Aandachtspunt(String code, String naamAandachtsPunt, String omschrijving, boolean actief) {
        this.code = code;
        this.naamAandachtsPunt = naamAandachtsPunt;
        this.omschrijving = omschrijving;
        this.actief = actief;
    }

    public Aandachtspunt() {

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

    public String getNaamAandachtsPunt() {
        return naamAandachtsPunt;
    }

    public void setNaamAandachtsPunt(String naamAandachtsPunt) {
        this.naamAandachtsPunt = naamAandachtsPunt;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aandachtspunt that = (Aandachtspunt) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
