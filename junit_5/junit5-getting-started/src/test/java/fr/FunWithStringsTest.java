package fr;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.expectThrows;

public class FunWithStringsTest {

    private final FunWithStrings fun = new FunWithStrings();

    @Test
    public void cas_nominal_string_non_null() {
        assertEquals("hello:5", fun.getStringLength("hello"), () -> "'hello' (length: 5) wasn't calculated properly");
    }

    @Test
    @Disabled("n'est plus nécessaire depuis TestFactory")
    public void cas_nominal_string_null() {
        assertEquals("   :3", fun.getStringLength(null), () -> "'   :3' (length: 0) wasn't calculated properly");
    }

    @TestFactory
    public Stream<DynamicTest> test_plein_de_combinaisons() throws Exception {
        String[][] data = {
                //entrée , attendu
                {"hello", "hello:5"},
                {"hell", "hell:4"},
                {"h", "h:1"},
                {"", ":0"},
                {"   ", "   :3"}
        };

        return Stream.of(data).map(o -> DynamicTest.dynamicTest("test" + o[0], () -> assertEquals(o[1], fun.getStringLength(o[0]))));
    }

    @Test
    public void test_exception() {
        NullPointerException exception = expectThrows(NullPointerException.class, () -> fun.getStringLength(null));

        assertEquals(null, exception.getMessage());
    }

}