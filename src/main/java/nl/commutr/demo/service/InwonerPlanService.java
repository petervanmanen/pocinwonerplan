package nl.commutr.demo.service;

import nl.commutr.demo.domain.aanbod.Aanbod;
import nl.commutr.demo.domain.aanbod.Aandachtspunt;
import nl.commutr.demo.domain.aanbod.Actiehouder;
import nl.commutr.demo.domain.inwonerplan.InwonerPlan;
import nl.commutr.demo.domain.aanbod.Ontwikkelwens;
import nl.commutr.demo.domain.aanbod.Subdoel;
import nl.commutr.demo.repository.AanbodRepository;
import nl.commutr.demo.repository.AandachtspuntRepository;
import nl.commutr.demo.repository.ActiehouderRepository;
import nl.commutr.demo.repository.InwonerplanRepository;
import nl.commutr.demo.repository.OntwikkelwensRepository;
import nl.commutr.demo.repository.SubdoelRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InwonerPlanService {

    @Autowired
    InwonerplanRepository repository;

    @Autowired
    AanbodRepository aanbodRepository;

    @Autowired
    AandachtspuntRepository aandachtspuntRepository;

    @Autowired
    OntwikkelwensRepository ontwikkelwensRepository;

    @Autowired
    SubdoelRepository subdoelRepository;

    @Autowired
    ActiehouderRepository actiehouderRepository;

    List<InwonerPlan> inwonerPlanList = new ArrayList<>();

    public void addInwonerplan(InwonerPlan inwonerPlan){
        repository.save(inwonerPlan);
    }



    public List<Aanbod> getAanbod(){
        return IteratorUtils.toList(aanbodRepository.findAll().iterator());
    }

    public List<Aandachtspunt> getAandachtspunten(){
        return IteratorUtils.toList(aandachtspuntRepository.findAll().iterator());
    }

    public List<Ontwikkelwens> getOntwikkelwensen(){
        return IteratorUtils.toList(ontwikkelwensRepository.findAll().iterator());
    }

    public List<Subdoel> getSubdoelen(){
        return IteratorUtils.toList(subdoelRepository.findAll().iterator());
    }

    public List<Actiehouder> getActiehouders(){
        return IteratorUtils.toList(actiehouderRepository.findAll().iterator());
    }

    public InwonerPlan getInwonerPlan(String bsn){
        return repository.findByBsn(bsn);
    }
}
