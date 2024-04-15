package nl.commutr.demo.domain.inwonerplan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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

    @OneToOne
    Subdoel subdoel;

    @OneToOne
    Aandachtspunt aandachtspunt;

    @OneToMany
    List<InwonerplanActiviteit> activiteiten;


    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
