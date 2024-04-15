package nl.commutr.demo.repository;

import nl.commutr.demo.domain.aanbod.AanbodActiviteit;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AanbodActiviteitRepository extends CrudRepository<AanbodActiviteit, UUID> {

    public AanbodActiviteit getAanbodActiviteitByNaamaanbodactiviteitIgnoreCase(String naam);

}
