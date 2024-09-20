package dev.atcx.tiramisu.base.utils;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class ResponseUtilsTest {

    @Test
    void testPrivateConstructor() throws NoSuchMethodException {
        Constructor<ResponseUtils> constructor = ResponseUtils.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
    }

    @Test
    void testResponseOk() {
        Response expectedResponse = Response.ok("1234").build();
        Response actualResponse = ResponseUtils.ok("1234");
        assertEquals(expectedResponse.getEntity(), actualResponse.getEntity());
        assertEquals(expectedResponse.getStatus(), actualResponse.getStatus());
        assertEquals(expectedResponse.getHeaders(), actualResponse.getHeaders());
    }

    @Test
    void testResponseOkNull() {
        Response expectedResponse = Response.ok(null).build();
        Response actualResponse = ResponseUtils.ok(null);
        assertEquals(expectedResponse.getEntity(), actualResponse.getEntity());
        assertEquals(expectedResponse.getStatus(), actualResponse.getStatus());
        assertEquals(expectedResponse.getHeaders(), actualResponse.getHeaders());
    }

    @Test
    void testResponseOkBody() {
        assertEquals("1234", ResponseUtils.ok("1234").getEntity());
    }

    @Test
    void testResponseOkNullBody() {
        assertNull(ResponseUtils.ok(null).getEntity());
    }

}
