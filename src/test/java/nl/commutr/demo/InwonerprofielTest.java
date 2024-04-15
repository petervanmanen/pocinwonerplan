package nl.commutr.demo;

import nl.commutr.demo.domain.InwonerProfiel;
import nl.commutr.demo.service.InwonerProfielService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InwonerprofielTest {

    @Autowired
    InwonerProfielService inwonerProfielService;

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
        inwonerProfielService.addInwonerprofiel(inwonerProfiel);
        InwonerProfiel inwonerProfielResolved = inwonerProfielService.getInwonerProfiel(String.valueOf(bsn));
        assertEquals("naam", "Manen", inwonerProfielResolved.getAchternaam());
    }

    @Test
    void shouldThrowExceptionWhenAddingProfielTwice(){
        InwonerProfiel inwonerProfiel = new InwonerProfiel();
        inwonerProfielService.addInwonerprofiel(inwonerProfiel);

        RuntimeException ex = Assertions.assertThrows(RuntimeException.class,() ->{
            inwonerProfielService.addInwonerprofiel(inwonerProfiel);
        });

        assertEquals("Exception should be thrown with message", "Profiel bestaat al",ex.getMessage());
    }

    @Test
    void shouldUpdateInwonerprofiel(){
        InwonerProfiel inwonerProfiel = new InwonerProfiel();
        inwonerProfiel.setBsn(String.valueOf(bsn));
        inwonerProfiel.setAchternaam("Manen");
        inwonerProfiel.setTussenvoegsel("van");
        inwonerProfiel.setTelefoonnummer("+31626955845");
        inwonerProfielService.addInwonerprofiel(inwonerProfiel);
        InwonerProfiel inwonerProfielResolved = inwonerProfielService.getInwonerProfiel(String.valueOf(bsn));
        inwonerProfielResolved.setVoornaam("Barry");
        inwonerProfielService.updateInwonerProfiel(inwonerProfielResolved);
        InwonerProfiel inwonerProfielResolvedAndUpdated = inwonerProfielService.getInwonerProfiel(String.valueOf(bsn));
        assertEquals("naam", "Barry", inwonerProfielResolvedAndUpdated.getVoornaam());
    }
}
