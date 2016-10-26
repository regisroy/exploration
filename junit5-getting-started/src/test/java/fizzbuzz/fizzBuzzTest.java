package fizzbuzz;

import org.junit.jupiter.api.*;

import java.util.stream.Stream;

import static java.util.stream.Stream.of;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class fizzBuzzTest {
    private FizzBuzz fizzBuzz;

    /* Règles :
       --------
    1. Compter entre 0 et 100
    2. Multiples de 3      => Fizz
    3. Multiples de 5      => Buzz
    4. Multiples de 3 et 5 => FizzBuzz?
    */

    @BeforeEach
    public void setUp() throws Exception {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    @DisplayName("devrait retourner 1 quand 1")
    public void name() throws Exception {
        assertEquals("1", fizzBuzz.compute(1), () -> "devrait retourner 1");
        assertEquals("2", fizzBuzz.compute(2), () -> "devrait retourner 2");
    }

    @TestFactory
    public Stream<DynamicTest> test_normal() throws Exception {
        String [][] data = {
                {"1","1"},
                {"2","2"},
                {"3","Fizz"},
                {"6","Fizz"},
        };

        return of(data)
                .map(o-> dynamicTest("test "+o[0], () ->assertEquals(o[1], fizzBuzz.compute(o[0]))));
    }



    @Test
//    @Disabled("parce que pour l'instant ca marche pô")
    public void devrait_retourner_fizz_quand_multiple_de_3() throws Exception {
        assertAll(
                () -> assertEquals("Fizz", fizzBuzz.compute(3)),
                () -> assertEquals("Fizz", fizzBuzz.compute(6)),
                () -> assertEquals("Fizz", fizzBuzz.compute(9))
        );
    }

    @Test
    public void quand_erreur_3() throws Exception {
        NullPointerException exception = expectThrows(NullPointerException.class, () -> fizzBuzz.compute((Integer) null));
        assertEquals(null, exception.getMessage());
    }
}
