package nl.commutr.demo.domain.aanbod;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

@Entity
public class AanbodActiviteit {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    UUID id;

    String codeaanbodactiviteit;

    String naamaanbodactiviteit;

    @ManyToOne
    Actiehouder actiehouder;

    int afhandeltermijn;

    boolean actief;

    @JsonIgnore
    String actiehouderlabel;

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

    public Actiehouder getActiehouder() {
        return actiehouder;
    }

    public void setActiehouder(Actiehouder actiehouder) {
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

    @JsonIgnore
    public String getActiehouderlabel() {
        return actiehouderlabel;
    }
@JsonProperty
    public void setActiehouderlabel(String actiehouderlabel) {
        this.actiehouderlabel = actiehouderlabel;
    }
}
