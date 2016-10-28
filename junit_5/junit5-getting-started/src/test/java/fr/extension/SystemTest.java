package fr.extension;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockedSystemExtension.class)
public class SystemTest {

    @Test
    public void test(final MockedSystem mockedSystem) {
        final Response response = mockedSystem.target().request().get();

        assertEquals(response.getStatusInfo().getFamily(), Response.Status.Family.SUCCESSFUL, () -> "status code is not 2xx");
        assertEquals(response.getHeaderString("X-Hello"), "World", () -> "header 'X-Hello' not correct");
    }

}