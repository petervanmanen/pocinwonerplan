package nl.commutr.demo;

import nl.commutr.demo.domain.aanbod.Aanbod;
import nl.commutr.demo.domain.aanbod.AanbodActiviteit;
import nl.commutr.demo.domain.aanbod.Aandachtspunt;
import nl.commutr.demo.domain.inwonerplan.InwonerPlan;
import nl.commutr.demo.repository.AanbodActiviteitRepository;
import nl.commutr.demo.repository.AanbodRepository;
import nl.commutr.demo.repository.AandachtspuntRepository;
import nl.commutr.demo.repository.InwonerplanRepository;
import nl.commutr.demo.repository.SubdoelRepository;
import nl.commutr.demo.service.InwonerPlanService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DemoApplicationTests {

    @Autowired
    InwonerPlanService inwonerPlanService;

    @Test
    void shouldReturnActiehouders(){
        assertEquals("shouldreturn3actiehouders", 3, inwonerPlanService.getActiehouders().size());
    }

    @Test
    void shouldReturnAandachtspunten() {
        assertEquals("should return 11 aandachtspunten", 11, inwonerPlanService.getAandachtspunten().size());
    }

    @Test
    void shouldReturnVerslaving() {
        assertEquals("shouldReturnVerslaving", "Verslaving", inwonerPlanService.getAandachtspunten().get(2).getNaamAandachtsPunt());
    }

    @Test
    void shouldReturnOntwikkelwensen() {
        assertEquals("should return 10 ontwikkelwensen", 10, inwonerPlanService.getOntwikkelwensen().size());
    }

    @Test
    void shouldReturnSubdoelen() {
        assertEquals("should return 10 subdoelen", 47, inwonerPlanService.getSubdoelen().size());
    }

    @Test
    void shouldReturnAanbod() {
        assertEquals("should return 54 aanbod", 54, inwonerPlanService.getAanbod().size());
    }

    @Test
    void actiehouderShouldHaveLabel(){
        assertEquals("actiehouder should be coach","Coach",inwonerPlanService.getAanbod().get(0).getAanbodActiviteiten().get(0).getActiehouder().naam);
        assertEquals("actiehouder should be Ondersteuner","Ondersteuner",inwonerPlanService.getAanbod().get(0).getAanbodActiviteiten().get(1).getActiehouder().naam);
    }
    @Test
    void aanbodShouldHaveTreeActvities() {
        assertEquals("aanbodShouldHaveTreeActvities", 3, inwonerPlanService.getAanbod().getFirst().getAanbodActiviteiten().size());
    }

    @Test
    void activiteitShouldBeRapportbespreken() {
        assertEquals("activiteitShouldBeRapportbespreken", "Rapport bespreken", inwonerPlanService.getAanbod().get(50).getAanbodActiviteiten().get(4).getNaamaanbodactiviteit());
    }

    @Test
    void hoofddoelShouldBeVerslaving() {
        InwonerPlan inwonerPlan = new InwonerPlan("111222333", inwonerPlanService.getSubdoelen().get(4));
        assertEquals("hoofddoel should be verslaving", "Ik ben onder behandeling voor mijn verslavingsproblematiek",inwonerPlan.hoofddoel.naamDoel);
    }
}
