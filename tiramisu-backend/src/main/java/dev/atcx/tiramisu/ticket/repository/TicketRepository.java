package dev.atcx.tiramisu.ticket.repository;

import dev.atcx.tiramisu.ticket.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
    Optional<Ticket> findByKey(String key);

    List<Ticket> findByKeyStartsWith(String keyPrefix);

    List<Ticket> findAll();
}
