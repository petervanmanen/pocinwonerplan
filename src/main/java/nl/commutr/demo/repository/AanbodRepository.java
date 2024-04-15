package nl.commutr.demo.repository;

import nl.commutr.demo.domain.aanbod.Aanbod;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AanbodRepository extends CrudRepository<Aanbod, UUID> {

}
