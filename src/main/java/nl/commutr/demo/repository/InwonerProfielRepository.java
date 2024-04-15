package nl.commutr.demo.repository;

import nl.commutr.demo.domain.inwonerplan.InwonerPlan;
import nl.commutr.demo.domain.InwonerProfiel;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface InwonerProfielRepository extends CrudRepository<InwonerProfiel, UUID> {
    InwonerPlan findByBsn(String bsn);
}
