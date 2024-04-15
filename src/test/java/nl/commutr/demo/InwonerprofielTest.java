package nl.commutr.demo;

import nl.commutr.demo.domain.InwonerProfiel;
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
class InwonerprofielTest {

    @Autowired
    InwonerPlanService inwonerPlanService;

    int bsn = 123456789;

    @BeforeEach
    void bsnIncrement(){
        bsn += 1;
    }

    @Test
    void shouldAddInwonerprofiel(){
        InwonerProfiel inwonerProfiel = new InwonerProfiel();
        inwonerProfiel.setBsn(String.valueOf(bsn));
        inwonerProfiel.setAchternaam("Manen");
        inwonerProfiel.setTussenvoegsel("van");
        inwonerProfiel.setTelefoonnummer("+31626955845");
        inwonerPlanService.addInwonerprofiel(inwonerProfiel);
        InwonerProfiel inwonerProfielResolved = inwonerPlanService.getInwonerProfiel(String.valueOf(bsn));
        assertEquals("naam", "Manen", inwonerProfielResolved.getAchternaam());
    }

    @Test
    void shouldThrowExceptionWhenAddingProfielTwice(){
        InwonerProfiel inwonerProfiel = new InwonerProfiel();
        inwonerPlanService.addInwonerprofiel(inwonerProfiel);

        RuntimeException ex = Assertions.assertThrows(RuntimeException.class,() ->{
            inwonerPlanService.addInwonerprofiel(inwonerProfiel);
        });

        assertEquals("Exception should be thrown with message", "Profiel bestaat al",ex.getMessage());

    }
}
