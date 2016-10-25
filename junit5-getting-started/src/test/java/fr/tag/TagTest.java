package fr.tag;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TagTest {

    @Test
    @Tag("integration")
    void runsWithCustomAnnotation() {
        assertTrue(true);
    }
}
