package nl.commutr.demo.api;

import nl.commutr.demo.domain.aanbod.Aanbod;
import nl.commutr.demo.domain.aanbod.Aandachtspunt;
import nl.commutr.demo.domain.aanbod.Ontwikkelwens;
import nl.commutr.demo.domain.aanbod.Subdoel;
import nl.commutr.demo.service.InwonerPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StamtabelController {

    @Autowired
    InwonerPlanService inwonerPlanService;

    @RequestMapping(value="/aanbod",method = RequestMethod.GET)
    public List<Aanbod> getAanbod(){
        return inwonerPlanService.getAanbod();
    }
    @RequestMapping(value="/aandachtspunten",method = RequestMethod.GET)
    public List<Aandachtspunt> getAandachtspunten(){
        return inwonerPlanService.getAandachtspunten();
    }
    @RequestMapping(value="/ontwikkelwensen",method = RequestMethod.GET)
    public List<Ontwikkelwens> getOntwikkelwensen(){
        return inwonerPlanService.getOntwikkelwensen();
    }
    @RequestMapping(value="/subdoelen",method = RequestMethod.GET)
    public List<Subdoel> getSubdoelen(){
        return inwonerPlanService.getSubdoelen();
    }
}
