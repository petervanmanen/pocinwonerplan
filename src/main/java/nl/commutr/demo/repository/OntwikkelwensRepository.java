package nl.commutr.demo.repository;

import nl.commutr.demo.domain.aanbod.Ontwikkelwens;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OntwikkelwensRepository extends CrudRepository<Ontwikkelwens, UUID> {
    public Ontwikkelwens getOntwikkelwensByCode(String code);
}
