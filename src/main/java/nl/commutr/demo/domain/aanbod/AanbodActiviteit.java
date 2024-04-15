package nl.commutr.demo.domain.aanbod;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class AanbodActiviteit {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    UUID id;

    String codeaanbodactiviteit;

    String naamaanbodactiviteit;

    String actiehouder;

    int afhandeltermijn;

    boolean actief;

    public AanbodActiviteit() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCodeaanbodactiviteit() {
        return codeaanbodactiviteit;
    }

    public void setCodeaanbodactiviteit(String codeaanbodactiviteit) {
        this.codeaanbodactiviteit = codeaanbodactiviteit;
    }

    public String getNaamaanbodactiviteit() {
        return naamaanbodactiviteit;
    }

    public void setNaamaanbodactiviteit(String naamaanbodactiviteit) {
        this.naamaanbodactiviteit = naamaanbodactiviteit;
    }

    public String getActiehouder() {
        return actiehouder;
    }

    public void setActiehouder(String actiehouder) {
        this.actiehouder = actiehouder;
    }

    public int getAfhandeltermijn() {
        return afhandeltermijn;
    }

    public void setAfhandeltermijn(int afhandeltermijn) {
        this.afhandeltermijn = afhandeltermijn;
    }

    public boolean isActief() {
        return actief;
    }

    public void setActief(boolean actief) {
        this.actief = actief;
    }

    public AanbodActiviteit(String codeaanbodactiviteit, String naamaanbodactiviteit, String actiehouder, int afhandeltermijn, boolean actief) {
        this.codeaanbodactiviteit = codeaanbodactiviteit;
        this.naamaanbodactiviteit = naamaanbodactiviteit;
        this.actiehouder = actiehouder;
        this.afhandeltermijn = afhandeltermijn;
        this.actief = actief;
    }
}
