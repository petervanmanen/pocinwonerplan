package nl.commutr.demo.api;

import nl.commutr.demo.domain.InwonerProfiel;
import nl.commutr.demo.domain.inwonerplan.InwonerPlan;
import nl.commutr.demo.service.InwonerPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InwonerProfielController {
    @Autowired
    InwonerPlanService inwonerPlanService;

    @RequestMapping(value="/inwonerprofiel",method = RequestMethod.POST)
    public void createInwonerplan(InwonerProfiel inwonerProfiel){
        inwonerPlanService.addInwonerprofiel(inwonerProfiel);
    }

    @RequestMapping(value="/inwonerprofiel",method = RequestMethod.GET)
    public void createInwonerplan(String bsn){
        inwonerPlanService.getInwonerProfiel(bsn);
    }
}
