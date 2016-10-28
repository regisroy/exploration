package fizzbuzz;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class fizzBuzzTest {
    private Fizzbuzz Fizzbuzz;
    private fizzbuzz.Fizzbuzz fizzbuzz;

    /* Règles :
       --------
    1. Compter entre 0 et 100
    2. Multiples de 3      => Fizz
    3. Multiples de 5      => Buzz
    4. Multiples de 3 et 5 => Fizzbuzz?
    */

    @BeforeEach
    public void setUp() throws Exception {
        fizzbuzz = new Fizzbuzz();
    }

    @Test
    @DisplayName("When 1 return 1")
    @Disabled
    public void name() throws Exception {
        assertAll(
                () -> assertEquals("1", fizzbuzz.compute("1")),
                () -> assertEquals("2", fizzbuzz.compute("2")),
                () -> assertEquals("7", fizzbuzz.compute("7"))
        );
    }

    @TestFactory
    public Stream<DynamicTest> name2() throws Exception {
        String[][] data = {
                {"1", "1"},
                {"2", "2"},
                {"7", "7"},
                {"5", "Buzz"},
                {"3", "Fizz"},
        };
        return Stream
                .of(data)
                .map(o -> DynamicTest.dynamicTest("test" + o[0],
                        () -> assertEquals(o[1], fizzbuzz.compute(o[0]))));


    }

    @Test
    public void name3(TestInfo testInfo, TestReporter testReporter) throws Exception {
        NumberFormatException exception = expectThrows(NumberFormatException.class,
                () -> fizzbuzz.compute(null));
        assertEquals("null", exception.getMessage());
        String displayName = testInfo.getDisplayName();
        System.out.println("displayName = " + displayName);

        testReporter.publishEntry("toto", "xxxx");

    }
}
