package nl.commutr.demo.domain.aanbod;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Aanbod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String naam;
    @ManyToMany(fetch = FetchType.EAGER)
    List<AanbodActiviteit> aanbodActiviteiten;

    @ManyToMany(fetch = FetchType.LAZY)
    //@ManyToMany(fetch = FetchType.EAGER)
    List<Subdoel> subdoelen;

    @JsonIgnore
    public String subdoel;
    @JsonIgnore
    public String activiteiten;


    public Aanbod() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }


    public List<AanbodActiviteit> getAanbodActiviteiten() {
        return aanbodActiviteiten;
    }

    public void setAanbodActiviteiten(List<AanbodActiviteit> aanbodActiviteiten) {
        this.aanbodActiviteiten = aanbodActiviteiten;
    }

    @JsonIgnore
    public List<Subdoel> getSubdoelen() {
        return subdoelen;
    }

    @JsonProperty
    public void setSubdoelen(List<Subdoel> subdoelen) {
        this.subdoelen = subdoelen;
    }

    @JsonIgnore
    public String getSubdoel() {
        return subdoel;
    }

    @JsonProperty
    public void setSubdoel(String subdoel) {
        this.subdoel = subdoel;
    }

    @JsonIgnore
    public String getActiviteiten() {
        return activiteiten;
    }

    @JsonProperty
    public void setActiviteiten(String activiteiten) {
        this.activiteiten = activiteiten;
    }

    public void addActiviteit(AanbodActiviteit activiteit) {
        if (this.aanbodActiviteiten == null) {
            this.aanbodActiviteiten = new ArrayList<>();
        }
        this.aanbodActiviteiten.add(activiteit);
    }

    public void addSubdoel(Subdoel subdoel) {
        if (this.subdoelen == null) {
            this.subdoelen = new ArrayList<>();
        }
        this.subdoelen.add(subdoel);
    }
}
