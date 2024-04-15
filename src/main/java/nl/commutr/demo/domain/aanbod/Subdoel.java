package nl.commutr.demo.domain.aanbod;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Subdoel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    UUID uuid;
    String code;
    String naam;

    boolean actief;


    String aandachtspuntenCodes;

    @ManyToMany(fetch = FetchType.EAGER)
    List<Aandachtspunt> aandachtspunten;

    @ManyToMany(fetch = FetchType.EAGER)
    List<Ontwikkelwens> ontwikkelwensen;

    public Subdoel(String code, String naam, boolean actief, List<Aandachtspunt> aandachtspunten) {
        this.code = code;
        this.naam = naam;
        this.actief = actief;
        this.aandachtspunten = aandachtspunten;
    }

    public Subdoel() {

    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    public boolean isActief() {
        return actief;
    }

    public void setActief(boolean actief) {
        this.actief = actief;
    }

    public List<Aandachtspunt> getAandachtspunten() {
        return aandachtspunten;
    }

    public void setAandachtspunten(List<Aandachtspunt> aandachtspunten) {
        this.aandachtspunten = aandachtspunten;
    }

    public List<Ontwikkelwens> getOntwikkelwensen() {
        return ontwikkelwensen;
    }

    public void setOntwikkelwensen(List<Ontwikkelwens> ontwikkelwensen) {
        this.ontwikkelwensen = ontwikkelwensen;
    }

    @JsonIgnore
    public String getAandachtspuntenCodes() {
        return aandachtspuntenCodes;
    }
    @JsonProperty
    public void setAandachtspuntenCodes(String aandachtspuntenCodes) {
        this.aandachtspuntenCodes = aandachtspuntenCodes;
    }

    public void addAandachtspunt(Aandachtspunt aandachtspunt){
        if(this.aandachtspunten==null){
            this.aandachtspunten = new ArrayList<>();
        }
        this.aandachtspunten.add(aandachtspunt);
    }

    public void addOntwikkelwens(Ontwikkelwens ontwikkelwens){
        if(this.ontwikkelwensen==null){
            this.ontwikkelwensen = new ArrayList<>();
        }
        this.ontwikkelwensen.add(ontwikkelwens);
    }
}
