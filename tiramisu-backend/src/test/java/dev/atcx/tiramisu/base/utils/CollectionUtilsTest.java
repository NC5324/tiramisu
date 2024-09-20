package dev.atcx.tiramisu.base.utils;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class CollectionUtilsTest {

    @Test
    void testPrivateConstructor() throws NoSuchMethodException {
        Constructor<CollectionUtils> constructor = CollectionUtils.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
    }

    @Test
    void testIsEmptyArray() {
        assertTrue(CollectionUtils.isEmpty(new Object[]{}));
    }

    @Test
    void testIsNotEmptyArray() {
        assertFalse(CollectionUtils.isNotEmpty(new Object[]{}));
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    void testIsEmptyNullArray() {
        assertTrue(CollectionUtils.isEmpty(null));
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    void testIsNotEmptyNullArray() {
        assertFalse(CollectionUtils.isNotEmpty(null));
    }

    @Test
    <T> void testIterableToList() {
        assertInstanceOf(List.class, CollectionUtils.toList(new HashSet<T>()));
    }

}
