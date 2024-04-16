package nl.commutr.demo.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import nl.commutr.demo.domain.InwonerProfiel;
import nl.commutr.demo.service.InwonerProfielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Inwonerprofiel")
public class InwonerProfielController {
    @Autowired
    InwonerProfielService inwonerProfielService;

    @RequestMapping(value="/inwonerprofiel",method = RequestMethod.POST)
    public void createInwonerProfiel(InwonerProfiel inwonerProfiel){
        inwonerProfielService.addInwonerprofiel(inwonerProfiel);
    }

    @RequestMapping(value="/inwonerprofiel",method = RequestMethod.GET)
    public void createInwonerProfiel(String bsn){
        inwonerProfielService.getInwonerProfiel(bsn);
    }

    @RequestMapping(value="/inwonerprofiel",method = RequestMethod.PUT)
    public void updateInwonerProfiel(InwonerProfiel inwonerProfiel){
        inwonerProfielService.updateInwonerProfiel(inwonerProfiel);
    }
}
