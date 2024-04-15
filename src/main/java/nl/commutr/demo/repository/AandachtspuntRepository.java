package nl.commutr.demo.repository;

import nl.commutr.demo.domain.aanbod.Aandachtspunt;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AandachtspuntRepository extends CrudRepository<Aandachtspunt, UUID> {
    public Aandachtspunt getAandachtspuntByCode(String code);
}
