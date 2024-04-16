package nl.commutr.demo.api;


import io.swagger.v3.oas.annotations.tags.Tag;
import nl.commutr.demo.domain.InwonerProfiel;
import nl.commutr.demo.service.InwonerProfielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Tag(name = "Inwonerprofiel")
public class InwonerProfielController {
    @Autowired
    InwonerProfielService inwonerProfielService;

    @RequestMapping(value="/inwonerprofiel",method = RequestMethod.POST)
    public void createInwonerProfiel(@RequestBody InwonerProfiel inwonerProfiel){
        inwonerProfielService.addInwonerprofiel(inwonerProfiel);
    }

    @RequestMapping(value="/inwonerprofiel",method = RequestMethod.GET)
    public InwonerProfiel getInwonerProfiel(@RequestParam String bsn){
        if(inwonerProfielService.getInwonerProfiel(bsn) == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "InwonerProfiel"
            );
        }
        return inwonerProfielService.getInwonerProfiel(bsn);
    }

    @RequestMapping(value="/inwonerprofiel",method = RequestMethod.PUT)
    public void updateInwonerProfiel(@RequestBody InwonerProfiel inwonerProfiel){
        inwonerProfielService.updateInwonerProfiel(inwonerProfiel);
    }
}
