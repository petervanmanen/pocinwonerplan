package nl.commutr.demo;

import nl.commutr.demo.domain.aanbod.ActiviteitStatus;
import nl.commutr.demo.domain.inwonerplan.InwonerPlan;
import nl.commutr.demo.domain.inwonerplan.InwonerplanActiviteit;
import nl.commutr.demo.domain.inwonerplan.InwonerplanSubdoel;
import nl.commutr.demo.service.InwonerPlanService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InwonerplanTest {

    @Autowired
    InwonerPlanService inwonerPlanService;

    int bsn = 123456789;

    @BeforeEach
    void bsnIncrement(){
        bsn += 1;
    }



    @Test
    void hoofddoelShouldBeVerslaving() {
        InwonerPlan inwonerPlan = new InwonerPlan("111222333", inwonerPlanService.getSubdoelen().get(4),null);
        assertEquals("hoofddoel should be verslaving", "Ik ben onder behandeling voor mijn verslavingsproblematiek",inwonerPlan.hoofddoel.naamDoel);
    }

    @Test
    void subdoelShouldBeResolvedInInwonerplan(){
        InwonerplanSubdoel inwonerplanSubdoel = new InwonerplanSubdoel();
        inwonerplanSubdoel.setSubdoelUUID(inwonerPlanService.getSubdoelen().get(5).getUuid().toString());
        inwonerplanSubdoel.setAandachtspuntUUID(inwonerPlanService.getAandachtspunten().get(2).getId().toString());
        InwonerPlan inwonerPlan = new InwonerPlan(String.valueOf(bsn), inwonerPlanService.getSubdoelen().get(4),List.of(inwonerplanSubdoel));
        inwonerPlanService.addInwonerplan(inwonerPlan);

        InwonerPlan resolvedInwonerplan = inwonerPlanService.getInwonerPlan(String.valueOf(bsn));
        assertEquals("subdoelname should be verslavingsproblematiek","Ik heb hulp gevraagd voor mijn verslavingsproblematiek",resolvedInwonerplan.subdoelen.getFirst().getSubdoel().getNaam());
    }

    @Test
    void aandachtspuntShouldBeResolvedInInwonerplan(){
        InwonerplanSubdoel inwonerplanSubdoel = new InwonerplanSubdoel();
        inwonerplanSubdoel.setSubdoelUUID(inwonerPlanService.getSubdoelen().get(5).getUuid().toString());
        inwonerplanSubdoel.setAandachtspuntUUID(inwonerPlanService.getAandachtspunten().get(2).getId().toString());

        InwonerPlan inwonerPlan = new InwonerPlan(String.valueOf(bsn), inwonerPlanService.getSubdoelen().get(4),List.of(inwonerplanSubdoel));
        inwonerPlanService.addInwonerplan(inwonerPlan);

        InwonerPlan resolvedInwonerplan = inwonerPlanService.getInwonerPlan(String.valueOf(bsn));
        assertEquals("aandachtpuntname should be Verslaving","Verslaving",resolvedInwonerplan.subdoelen.getFirst().getAandachtspunt().getNaamAandachtsPunt());
    }

    @Test
    void subdoelWithNonExistingUUIDShouldThrow(){
        InwonerplanSubdoel inwonerplanSubdoel = new InwonerplanSubdoel();
        inwonerplanSubdoel.setSubdoelUUID(UUID.fromString("eb417c95-f0a8-4e04-8fd8-883ee40a6907").toString());
        inwonerplanSubdoel.setAandachtspuntUUID(inwonerPlanService.getAandachtspunten().get(2).getId().toString());

        InwonerPlan inwonerPlan = new InwonerPlan(String.valueOf(bsn), inwonerPlanService.getSubdoelen().get(4),List.of(inwonerplanSubdoel));

        RuntimeException ex = Assertions.assertThrows(NoSuchElementException.class,() ->{
            inwonerPlanService.addInwonerplan(inwonerPlan);
        });

        assertEquals("Exception should be thrown with message", "No value present",ex.getMessage());
    }

    @Test
    void aandachtspuntWithNonExistingUUIDShouldThrow(){
        InwonerplanSubdoel inwonerplanSubdoel = new InwonerplanSubdoel();
        inwonerplanSubdoel.setAandachtspuntUUID(UUID.fromString("eb417c95-f0a8-4e04-8fd8-883ee40a6907").toString());
        inwonerplanSubdoel.setSubdoelUUID(inwonerPlanService.getSubdoelen().get(7).getUuid().toString());
        InwonerPlan inwonerPlan = new InwonerPlan(String.valueOf(bsn), inwonerPlanService.getSubdoelen().get(4),List.of(inwonerplanSubdoel));

        RuntimeException ex = Assertions.assertThrows(NoSuchElementException.class,() ->{
            inwonerPlanService.addInwonerplan(inwonerPlan);
        });

        assertEquals("Exception should be thrown with message", "No value present",ex.getMessage());
    }

    @Test
    void subdoelwithnonrelatedaandachtspuntshouldthrow(){
        InwonerplanSubdoel inwonerplanSubdoel = new InwonerplanSubdoel();
        inwonerplanSubdoel.setAandachtspuntUUID(inwonerPlanService.getAandachtspunten().get(2).getId().toString());
        inwonerplanSubdoel.setSubdoelUUID(inwonerPlanService.getSubdoelen().get(7).getUuid().toString());
        InwonerPlan inwonerPlan = new InwonerPlan(String.valueOf(bsn), inwonerPlanService.getSubdoelen().get(4),List.of(inwonerplanSubdoel));

        RuntimeException ex = Assertions.assertThrows(RuntimeException.class,() ->{
            inwonerPlanService.addInwonerplan(inwonerPlan);
        });

        assertEquals("Exception should be thrownwith message", "Subdoel and aandachtspunt are not related",ex.getMessage());
    }

    @Test
    void subdoelShouldHaveActiviteiten(){
        InwonerplanSubdoel inwonerplanSubdoel = new InwonerplanSubdoel();
        inwonerplanSubdoel.setSubdoelUUID(inwonerPlanService.getSubdoelen().get(5).getUuid().toString());
        inwonerplanSubdoel.setAandachtspuntUUID(inwonerPlanService.getAandachtspunten().get(2).getId().toString());

        InwonerplanActiviteit inwonerplanActiviteit = new InwonerplanActiviteit();
        inwonerplanActiviteit.setActiehouderOmschrijving("coach");
        inwonerplanActiviteit.setStatus(ActiviteitStatus.OPEN);
        inwonerplanActiviteit.setBegindatum(LocalDate.now());
        inwonerplanActiviteit.setEinddatum(LocalDate.now().plusDays(5));
        inwonerplanActiviteit.setNaam("Test activiteit 1");

        InwonerplanActiviteit inwonerplanActiviteit2 = new InwonerplanActiviteit();
        inwonerplanActiviteit2.setActiehouderOmschrijving("Coach Werk");
        inwonerplanActiviteit2.setStatus(ActiviteitStatus.OPEN);
        inwonerplanActiviteit2.setBegindatum(LocalDate.now());
        inwonerplanActiviteit2.setEinddatum(LocalDate.now().plusDays(5));
        inwonerplanActiviteit2.setNaam("Test activiteit 2");
        inwonerplanSubdoel.setActiviteiten(List.of(inwonerplanActiviteit,inwonerplanActiviteit2));
        InwonerPlan inwonerPlan = new InwonerPlan(String.valueOf(bsn), inwonerPlanService.getSubdoelen().get(4),List.of(inwonerplanSubdoel));

        inwonerPlanService.addInwonerplan(inwonerPlan);

        InwonerPlan inwonerplanResolved = inwonerPlanService.getInwonerPlan(String.valueOf(bsn));
        assertEquals("actiehouder should be coach","Coach",inwonerplanResolved.subdoelen.get(0).getActiviteiten().get(0).getActiehouder().naam);
        assertEquals("actiehouder should be coach","Coach Werk",inwonerplanResolved.subdoelen.get(0).getActiviteiten().get(1).getActiehouder().naam);
    }
}
