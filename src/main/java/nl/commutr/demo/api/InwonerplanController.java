package nl.commutr.demo.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import nl.commutr.demo.domain.inwonerplan.InwonerPlan;
import nl.commutr.demo.service.InwonerPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@Tag(name = "Inwonerplan")
public class InwonerplanController {

    @Autowired
    InwonerPlanService inwonerPlanService;

    @RequestMapping(value="/inwonerplan",method = RequestMethod.POST)
    public InwonerPlan createInwonerplan(InwonerPlan inwonerPlan){
        inwonerPlanService.addInwonerplan(inwonerPlan);
        return inwonerPlan;
    }

    @RequestMapping(value="/inwonerplan",method = RequestMethod.GET)
    public InwonerPlan createInwonerplan(String bsn) throws HttpClientErrorException.NotFound {
        return inwonerPlanService.getInwonerPlan(bsn);
    }
}
