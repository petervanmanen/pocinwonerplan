package nl.commutr.demo.domain.inwonerplan;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import nl.commutr.demo.domain.aanbod.Aandachtspunt;
import nl.commutr.demo.domain.aanbod.Subdoel;

import java.util.List;
import java.util.UUID;

@Entity
public class InwonerplanSubdoel {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    Subdoel subdoel;

    @ManyToOne
    Aandachtspunt aandachtspunt;

    @OneToMany
    List<InwonerplanActiviteit> activiteiten;

    public String aandachtspuntUUID;

    public String subdoelUUID;


    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    @JsonIgnore
    public Subdoel getSubdoel() {
        return subdoel;
    }

    public void setSubdoel(Subdoel subdoel) {
        this.subdoel = subdoel;
    }

    @JsonIgnore
    public Aandachtspunt getAandachtspunt() {
        return aandachtspunt;
    }

    public void setAandachtspunt(Aandachtspunt aandachtspunt) {
        this.aandachtspunt = aandachtspunt;
    }

    public List<InwonerplanActiviteit> getActiviteiten() {
        return activiteiten;
    }

    public void setActiviteiten(List<InwonerplanActiviteit> activiteiten) {
        this.activiteiten = activiteiten;
    }

    public String getAandachtspuntUUID() {
        if(this.aandachtspunt!=null){
            this.aandachtspunt.getId().toString();
        }
        if(this.aandachtspuntUUID!=null){
            return aandachtspuntUUID;
        }
        return null;
    }

    public void setAandachtspuntUUID(String aandachtspuntUUID) {
        this.aandachtspuntUUID = aandachtspuntUUID;
    }

    public String getSubdoelUUID() {
        if(this.subdoel!=null){
            return this.subdoel.getUuid().toString();
        }
        if(this.subdoelUUID!=null){
            return this.subdoelUUID;
        }
        return null;
    }

    public void setSubdoelUUID(String subdoelUUID) {
        this.subdoelUUID = subdoelUUID;
    }
}
