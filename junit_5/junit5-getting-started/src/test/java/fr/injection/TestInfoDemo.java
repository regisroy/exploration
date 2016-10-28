package fr.injection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

import java.util.HashMap;

class TestInfoDemo {

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        String displayName = testInfo.getDisplayName();
        assertTrue(displayName.equals("TEST 1") || displayName.equals("test2()"));
        HashMap<String, String> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("param1", "value1");
        testReporter.publishEntry(objectObjectHashMap);
    }

    @Test
    @DisplayName("TEST 1")
    @Tag("my tag")
    void test1(TestInfo testInfo) {
        assertEquals("TEST 1", testInfo.getDisplayName());
        assertTrue(testInfo.getTags().contains("my tag"));
    }

    @Test
    void test2() {
        assertTrue(true, "Test qui ne valide rien :-)");
    }

}