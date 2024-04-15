package nl.commutr.demo.repository;

import nl.commutr.demo.domain.inwonerplan.InwonerPlan;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface InwonerplanRepository extends CrudRepository<InwonerPlan, UUID> {
    InwonerPlan findByBsn(String bsn);
}
