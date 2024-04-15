package nl.commutr.demo.domain.inwonerplan;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import nl.commutr.demo.domain.aanbod.Subdoel;

import java.util.List;
import java.util.UUID;


@Entity
public class InwonerPlan {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public UUID uuid;
    public String bsn;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public InwonerplanHoofdDoel hoofddoel;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public List<InwonerplanSubdoel> subdoelen;

    public InwonerPlan(String bsn, Subdoel hoofddoel, List<InwonerplanSubdoel> subdoelen) {
        this.bsn = bsn;
        this.hoofddoel = new InwonerplanHoofdDoel(hoofddoel);
        this.subdoelen = subdoelen;
    }

    public InwonerPlan() {

    }
}
