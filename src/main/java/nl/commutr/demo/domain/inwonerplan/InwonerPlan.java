package nl.commutr.demo.domain.inwonerplan;

import jakarta.persistence.Entity;
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

    @OneToOne
    public InwonerplanHoofdDoel hoofddoel;

    @OneToMany
    public List<InwonerplanSubdoel> subdoelen;

    public InwonerPlan(String bsn, Subdoel hoofddoel) {
        this.bsn = bsn;
        this.hoofddoel = new InwonerplanHoofdDoel(hoofddoel);
    }

    public InwonerPlan() {

    }
}
