package dev.atcx.tiramisu.project;

import dev.atcx.tiramisu.base.BaseEntity;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

@QuarkusTest
class ProjectTest {

    @Test
    void testBaseEntityInstance() {
        assertInstanceOf(BaseEntity.class, new Project());
    }

}
