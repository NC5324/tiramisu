package dev.atcx.tiramisu.base;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

@QuarkusTest
class BaseEntityTest {

    @Test
    void testConstructor() {
        BaseEntity baseEntity = new BaseEntity();
        assertFalse(baseEntity.isDeleted());
        assertNull(baseEntity.getCreator());
        assertNull(baseEntity.getCreated());
        assertNull(baseEntity.getEditor());
        assertNull(baseEntity.getEdited());
    }

}
