package nl.commutr.demo.repository;

import nl.commutr.demo.domain.aanbod.Aanbod;
import nl.commutr.demo.domain.aanbod.Subdoel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface AanbodRepository extends CrudRepository<Aanbod, UUID> {
    List<Aanbod> getAanbodsBySubdoel(String subdoel);

    List<Aanbod> getAanbodsBySubdoelen(Subdoel subdoel);
}
