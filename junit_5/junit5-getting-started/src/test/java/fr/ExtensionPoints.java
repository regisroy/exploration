package fr;

import org.junit.jupiter.api.*;

public class ExtensionPoints {

    @BeforeEach
    void avantTest() {
        System.out.println("  Avant tests...");
    }

    @BeforeAll
    static void avantClass() {
        System.out.println("Creating external resources...");
    }

    @Test
    @DisplayName("premier_nom_de_test_utilisé")
    public void premierNomDeMethodeNonUtilise() throws Exception {
        System.out.println("    ExtensionPoints.premierNomDeMethodeNonUtilise");
    }

    @Test
    @DisplayName("second_nom_de_test_utilisé")
    public void secondNomDeMethodeNonUtilise() throws Exception {
        System.out.println("    ExtensionPoints.secondNomDeMethodeNonUtilise");
    }

    @AfterEach
    void tearDown() {
        System.out.println("  Après le test...");
    }

    @AfterAll
    static void freeExternalResources() {
        System.out.println("Freeing external resources...");
    }
}
