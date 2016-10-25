package fr.solution;


import fr.FunWithObject;
import fr.Maison;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FunWithObjectTest {

    @Test
    public void cas_nominal() throws Exception {
        FunWithObject fun = new FunWithObject();
        Maison maison = fun.getMaison("La belle Héloïse;105;5");
        assertAll(
                () -> assertNotNull(maison),
                () -> assertEquals("La belle Héloïse", maison.getNom()),
                () -> assertEquals("105", maison.getTailleM2()),
                () -> assertEquals("5", maison.getNombreDePieces())
        );

    }
}