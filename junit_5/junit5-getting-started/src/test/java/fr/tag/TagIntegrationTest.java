package fr.tag;

import org.junit.jupiter.api.Test;

public class TagIntegrationTest {

    @IntegrationTest
    void runsWithCustomAnnotation() {
        // this is run even though `@IntegrationTest` is not defined by JUnit
    }

    @Test
    public void name() throws Exception {
        System.out.println("Comme intelliJ n'est pas encore full compliant JUnit 5, je dois mettre un test factice. ;-)");

    }
}
