package dev.atcx.tiramisu.base.utils;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class NumberUtilsTest {

    @Test
    void testPrivateConstructor() throws NoSuchMethodException {
        Constructor<NumberUtils> constructor = NumberUtils.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
    }

    @Test
    void testParseLong() {
        assertEquals(1234L, NumberUtils.parseLong("1234"));
    }

    @Test
    void testParseLongSuffixedString() {
        assertEquals(1234L, NumberUtils.parseLong("1234L"));
    }

    @Test
    void testParseLongInvalidString() {
        assertNull(NumberUtils.parseLong("InvalidNumberString"));
    }

    @Test
    void testParseLongNull() {
        assertNull(NumberUtils.parseLong(null));
    }

}
