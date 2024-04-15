package nl.commutr.demo.service;

import nl.commutr.demo.domain.InwonerProfiel;
import nl.commutr.demo.repository.InwonerProfielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InwonerProfielService {
    @Autowired
    InwonerProfielRepository inwonerProfielRepository;
    public void addInwonerprofiel(InwonerProfiel inwonerProfiel){
        if(inwonerProfielRepository.findByBsn(inwonerProfiel.bsn)==null){
            inwonerProfielRepository.save(inwonerProfiel);
            return;
        }
        throw new RuntimeException("Profiel bestaat al");
    }

    public InwonerProfiel getInwonerProfiel(String bsn){
        return inwonerProfielRepository.findByBsn(bsn);
    }

    public void updateInwonerProfiel(InwonerProfiel inwonerProfiel){
        if(inwonerProfielRepository.findByBsn(inwonerProfiel.bsn)==null){
            throw new RuntimeException("Profiel bestaat nog niet");
        }
        inwonerProfielRepository.save(inwonerProfiel);
    }
}
