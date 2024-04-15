package nl.commutr.demo.repository;

import nl.commutr.demo.domain.aanbod.Actiehouder;
import nl.commutr.demo.domain.inwonerplan.InwonerPlan;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ActiehouderRepository extends CrudRepository<Actiehouder, UUID> {
    Actiehouder findByNaam(String naam);
}
