package dev.atcx.tiramisu.ticket;

import dev.atcx.tiramisu.base.BaseEntity;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

@QuarkusTest
class TicketTest {

    @Test
    void testBaseEntityInstance() {
        assertInstanceOf(BaseEntity.class, new Ticket());
    }

}
